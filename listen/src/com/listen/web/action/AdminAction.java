package com.listen.web.action;

import com.listen.domain.Library;
import com.listen.domain.LibraryPool;
import com.listen.domain.Student;
import com.listen.service.AdminService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;

/**
 * FileName AdminAction
 * Created by Exler
 * Time 2018-08-30 14:25
 * Description:
 */

public class AdminAction extends ActionSupport implements ModelDriven<Student> {

    private Student admin = new Student();
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

    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    @Override
    public Student getModel() {
        return admin;
    }
}
