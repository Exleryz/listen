package com.listen.web.action;

import com.listen.domain.Library;
import com.listen.domain.LibraryPool;
import com.listen.domain.Student;
import com.listen.domain.SysStudentLibraryPoolVo;
import com.listen.service.AdminService;
import com.listen.utils.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * FileName AdminAction
 * Created by Exler
 * Time 2018-08-30 14:25
 * Description:
 */
@Controller
@Scope("prototype")
public class AdminAction extends ActionSupport implements ModelDriven<Student> {

    private Student admin = new Student();
    @Autowired
    private AdminService adminService;

    /**
     * 查看当前关卡设置 规定分数。。。。 ajax及点击设置后的数据回显
     *
     * @return
     * @throws Exception
     */
    public String getCurrentScoreSet() throws Exception {
        String currentCheck = ServletActionContext.getRequest().getParameter("currentCheck");
        String currentGrade = ServletActionContext.getRequest().getParameter("currentGrade");
        JSONObject jsonObject = adminService.getCurrentCheckScoreSet(Integer.parseInt(currentCheck), Integer.parseInt(currentGrade));
        ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
        ServletActionContext.getResponse().getWriter().write(jsonObject.toString());
        return null;
    }

    /**
     * 显示关卡的详情信息
     *
     * @return
     * @throws Exception
     */
    public String seeDetails() throws Exception {
        String currentCheck = ServletActionContext.getRequest().getParameter("currentCheck");
        String currentGrade = ServletActionContext.getRequest().getParameter("currentGrade");
        LibraryPool libraryPool = adminService.getSetByGAndC(Integer.parseInt(currentCheck), Integer.parseInt(currentGrade));
        ActionContext.getContext().put("lp", libraryPool);
        return "toDetails";
    }

    /**
     * 单题详情查看
     *
     * @return
     * @throws Exception
     */
    public String getLibraryDetails() throws Exception {
        String libraryId = ServletActionContext.getRequest().getParameter("libraryId");
        System.out.println(libraryId);
        Library l = adminService.getLibraryDetails(Integer.parseInt(libraryId));
        ActionContext.getContext().put("library", l);
        return "seeDetail";
    }

    /**
     * 学生历史做题数据查询
     *
     * @return
     * @throws Exception
     */
    public String queryHistory() throws Exception {
        // 分页
        String currentPage = ServletActionContext.getRequest().getParameter("currentPage");
        // 传入的查询参数
        // 学生姓名 学号 分数(大于 小于) 时间戳 等级 关数
        SysStudentLibraryPoolVo vo = new SysStudentLibraryPoolVo();
        vo.setStudentName(ServletActionContext.getRequest().getParameter("studentName"));
        vo.setStudentAccount(ServletActionContext.getRequest().getParameter("studentAccount"));
        try {
            vo.setScore(Integer.parseInt(ServletActionContext.getRequest().getParameter("score")));
            vo.setGrade(Integer.parseInt(ServletActionContext.getRequest().getParameter("grade")));
            vo.setCheck(vo.getGrade() == null ? null : Integer.parseInt(ServletActionContext.getRequest().getParameter("check")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        vo.setScoreOperator(vo.getScore() == null ? null : ServletActionContext.getRequest().getParameter("scoreOperator"));
        vo.setTimeStart(ServletActionContext.getRequest().getParameter("timeStart"));
        vo.setTimeEnd(ServletActionContext.getRequest().getParameter("timeEnd"));

        // 默认查 测试
        if ("".equals(currentPage) || currentPage == null) {
            currentPage = "0";
        }
        PageBean pb = adminService.getQueryRecords(Integer.parseInt(currentPage), 10, vo);
        ActionContext.getContext().put("pageBean", pb);
//        return "librariesList";
        return super.execute();
    }

    /**
     * 登出
     *
     * @return
     * @throws Exception
     */
    public String loginOut() throws Exception {
        ActionContext.getContext().getSession().remove("admin");
        return "toLogin";
    }

    public AdminService getAdminService() {
        return adminService;
    }

    @Override
    public Student getModel() {
        return admin;
    }
}
