package com.listen.controller;

import com.listen.common.utils.ListenResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Exler
 */

@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping("/hello")
    @ResponseBody
    public ListenResult hello() {
        return ListenResult.success(null);
    }


//    /**
//     * 显示关卡的详情信息
//     *
//     * @return
//     * @throws Exception
//     */
//    public String seeDetails() throws Exception {
//        String currentCheck = ServletActionContext.getRequest().getParameter("currentCheck");
//        String currentGrade = ServletActionContext.getRequest().getParameter("currentGrade");
//        LibraryPool libraryPool = adminService.getSetByGAndC(Integer.parseInt(currentCheck), Integer.parseInt(currentGrade));
//        ActionContext.getContext().put("lp", libraryPool);
//        return "toDetails";
//    }


//    /**
//     * 学生历史做题数据查询
//     *
//     * @return
//     * @throws Exception
//     */
//    public String queryHistory() throws Exception {
//        // 分页
//        String currentPage = ServletActionContext.getRequest().getParameter("currentPage");
//        // 传入的查询参数
//        // 学生姓名 学号 分数(大于 小于) 时间戳 等级 关数
//        QuerySysStudentLibraryPoolVo vo = new QuerySysStudentLibraryPoolVo();
//        vo.setStudentName(ServletActionContext.getRequest().getParameter("studentName"));
//        vo.setStudentAccount(ServletActionContext.getRequest().getParameter("studentAccount"));
//        try {
//            vo.setScore(Integer.parseInt(ServletActionContext.getRequest().getParameter("score")));
//            vo.setGrade(Integer.parseInt(ServletActionContext.getRequest().getParameter("grade")));
//            vo.setCheck(vo.getGrade() == null ? null : Integer.parseInt(ServletActionContext.getRequest().getParameter("check")));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        vo.setScoreOperator(vo.getScore() == null ? null : ServletActionContext.getRequest().getParameter("scoreOperator"));
//        vo.setTimeStart(ServletActionContext.getRequest().getParameter("timeStart"));
//        vo.setTimeEnd(ServletActionContext.getRequest().getParameter("timeEnd"));
//
//        // 默认查 测试
//        if ("".equals(currentPage) || currentPage == null) {
//            currentPage = "0";
//        }
//        PageBean pb = adminService.getQueryRecords(Integer.parseInt(currentPage), 20, vo);
//        ListenResult result = new ListenResult("success", 100, pb);
//        JsonConfig config = new JsonConfig();
//        config.setExcludes(new String[]{"lp", "stu"});
//        JSONObject jsonObject = JSONObject.fromObject(result, config);
//        System.out.println(jsonObject.toString());
//        ServletActionContext.getResponse().getWriter().write(jsonObject.toString());
//        return null;
//    }

}
