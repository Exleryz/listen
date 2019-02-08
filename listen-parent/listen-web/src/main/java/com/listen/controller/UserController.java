package com.listen.controller;

import com.listen.common.redis.RedisHelper;
import com.listen.common.utils.ListenResult;
import com.listen.pojo.SysUserLibraryPool;
import com.listen.pojo.User;
import com.listen.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * FileName StudentAction
 *
 * @author Exler
 * Time 2018-08-30 14:28
 * Description:
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;
    @Value("${ANSWER_KEY}")
    private String ANSWER_KEY;
    @Value("${ANSWER_TIMEOUT}")
    private Integer ANSWER_TIMEOUT;

    @RequestMapping("/page/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/page/{folderName}/{pageName}")
    public ModelAndView page(@PathVariable String folderName, @PathVariable String pageName, ModelAndView modelAndView, HttpServletRequest request) {
        String path;
        if (null == pageName || "".equals(pageName)) {
            path = folderName;
        } else {
            path = folderName + "/" + pageName;
        }
        modelAndView.addObject("user", request.getAttribute("user"));
        modelAndView.setViewName(path);
        return modelAndView;
    }

    /**
     * ajax 检查账号是否存在
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/user/check")
    @ResponseBody
    public ListenResult checkAccount(User user) {
        // 参数检查
        if (StringUtils.isEmpty(user.getAccount())) {
            return ListenResult.error("账号不可为空");
        }
        User existUser = userService.selectUserByAccount(user.getAccount());
        if (existUser != null) {
            return ListenResult.error("账号已存在");
        }
        return ListenResult.success(null);
    }

    /**
     * 词汇测试提交 获取初始等级
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/user/submitGrade")
    @ResponseBody
    public ListenResult submitGrade(Float score, HttpServletRequest request) {
        User user = (User) request.getAttribute("user");
        // 参数检查
        if (null != user.getGrade() || null == score || null == user.getId()) {
            return ListenResult.error("获取用户初始等级失败");
        }
        ListenResult result = userService.initGradeCode(user, score);
        return result;
    }

    /**
     * 提交当前关卡的分数 classify 为null 认为是练习
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/user/submitScore")
    @ResponseBody
    public ListenResult submitScore(@RequestParam(value = "answers", defaultValue = "0") Character[] answers,
                                    Integer checkPoint, HttpServletRequest request) {
        RedisHelper.set(1 + "ANSWER_KEY:" + 1, "A:1;B:1;C:2;A:2;D:2;A:2;C:3", 1200, 1);
        if (null == checkPoint) {
            return ListenResult.error("试卷提交失败");
        }
        User user = (User) request.getAttribute("user");

        String answerStr = RedisHelper.get(user.getId() + ANSWER_KEY + ":" + checkPoint, 1);
        if (StringUtils.isEmpty(answerStr)) {
            return ListenResult.error("此试卷已过期");
        }
        System.out.println(answerStr);
        String[] kv = answerStr.split(";");
        if (answers.length != kv.length) {
            return ListenResult.error("试卷提交失败");
        }

        // 根据题目的权重算出正确率
        Double sumScore = 0d;
        Double rightScore = 0d;
        for (int i = 0; i < answers.length; i++) {
            String[] score = kv[i].split(":");
            if (score[0].equals(answers[i])) {
                sumScore += Integer.parseInt(score[1]);
            }
            rightScore += Integer.parseInt(score[1]);
        }
        Double score = Math.ceil(sumScore / rightScore);
        SysUserLibraryPool sysUserLibraryPool = new SysUserLibraryPool();
        sysUserLibraryPool.setScore(score);
        sysUserLibraryPool.setUserId(user.getId());
        return userService.saveScore(user, sysUserLibraryPool, checkPoint);
    }

    /**
     * 根据当前关卡 分页 返回历史记录
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/user/history")
    @ResponseBody
    public ListenResult getCurrentHistoryList(Integer checkPoint, Integer pageNum, Integer pageSize, HttpServletRequest request) {
        if (null == checkPoint) {
            return ListenResult.error("查询历史记录错误");
        }
        User user = (User) request.getAttribute("user");
        return userService.getHistoryPage(user, checkPoint, pageNum, pageSize);
    }

    /**
     * 测试专用
     *
     * @param args
     */
    public static void main(String[] args) {
//        添加redis中试卷答案

    }

}
