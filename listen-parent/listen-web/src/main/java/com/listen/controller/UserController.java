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
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private VocabularyService vocabularyService;
    @Autowired
    private LibraryPoolService libraryPoolService;

    /**
     * ajax 检查账号是否存在
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/check")
    @ResponseBody
    public ListenResult checkAccount(User user) throws Exception {
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
     * ajax 加载词汇
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/initGrade")
    @ResponseBody
    public ListenResult initGrade() throws Exception {
        ListenResult result = vocabularyService.initGradetest();
        return result;
    }

    /**
     * 词汇测试提交 获取初始等级
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/submitGrade")
    @ResponseBody
    public ListenResult submitGrade(Float score, HttpServletRequest request) throws Exception {
        User user = (User) request.getAttribute("user");
        // 参数检查
        if (null != user.getGrade() || null == score || null == user.getId()) {
            return ListenResult.error("获取用户初始等级失败");
        }
        ListenResult result = userService.initGradeCode(user, score);
        return result;
    }

    /**
     * ajax 加载听力试卷
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/initSubject")
    @ResponseBody
    public ListenResult initSubject(Integer checkPoint, HttpServletRequest request) throws Exception {
        User user = (User) request.getAttribute("user");
        if (null == user.getGrade() || null == checkPoint) {
            return ListenResult.error("试卷加载异常");
        }
        ListenResult result = libraryPoolService.getCurrentGradeSubjects(user.getGrade(), checkPoint);
        return result;
    }

    /**
     * 提交当前关卡的分数 classify 为null 认为是练习
     *
     * @return
     * @throws Exception
     */
    @RequestMapping("/submitScore")
    @ResponseBody
    public ListenResult submitScore(SysUserLibraryPool sysUserLibraryPool, Integer checkPoint, HttpServletRequest request) throws Exception {
        if (null == sysUserLibraryPool.getScore() || null == checkPoint) {
            return ListenResult.error("试卷提交失败");
        }
        User user = (User) request.getAttribute("user");
        return userService.saveScore(user, sysUserLibraryPool, checkPoint);
    }

//    /**
//     * 根据当前关卡 分页 返回当前关卡的历史记录
//     *
//     * @return
//     * @throws Exception
//     */
//    public String getCurrentHistoryList() throws Exception {
//        String currentCheck = ServletActionContext.getRequest().getParameter("currentCheck");
//        String currentPage = ServletActionContext.getRequest().getParameter("currentPage");
//        if (currentPage.equals("") && currentPage == null) {
//            currentPage = "0";
//        }
//        Student stu = (Student) ActionContext.getContext().getSession().get("student");
//        JSONObject jsonObject = studentService.getCurrentPageBean(stu, Integer.parseInt(currentPage), Integer.parseInt(currentCheck), 5);
//        ServletActionContext.getResponse().getWriter().write(jsonObject.toString());
//        return null;
//    }

}
