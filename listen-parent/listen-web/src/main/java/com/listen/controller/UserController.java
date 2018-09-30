package com.listen.controller;

import com.listen.common.utils.ListenResult;
import com.listen.pojo.SysUserLibraryPool;
import com.listen.pojo.User;
import com.listen.service.LibraryPoolService;
import com.listen.service.UserService;
import com.listen.service.VocabularyService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping("/index")
    public String index() {
        return "login";
    }

    @RequestMapping("/{role}/home")
    public String index(@PathVariable String role) {
        return role + "/home";
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
    public ListenResult submitScore(SysUserLibraryPool sysUserLibraryPool, Integer checkPoint, HttpServletRequest request) {
        if (null == sysUserLibraryPool.getScore() || null == checkPoint) {
            return ListenResult.error("试卷提交失败");
        }
        User user = (User) request.getAttribute("user");
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

}
