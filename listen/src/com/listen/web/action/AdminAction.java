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

import java.util.List;

public class AdminAction extends ActionSupport implements ModelDriven<Student> {

    private Student admin = new Student();
    private AdminService adminService;

    public String getCurrentScoreSet() throws Exception {
        String currentCheck = ServletActionContext.getRequest().getParameter("currentCheck");
        String currentGrade = ServletActionContext.getRequest().getParameter("currentGrade");
        JSONObject jsonObject = adminService.getCurrentCheckScoreSet(Integer.parseInt(currentCheck), Integer.parseInt(currentGrade));
        ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
        ServletActionContext.getResponse().getWriter().write(jsonObject.toString());
        return null;
    }

    /**
     * 点击设置时的数据回显
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
     * 获取所有题目(all) 分页待实现
     *
     * @return
     * @throws Exception
     */
    public String getAllLibraries() throws Exception {
        List<Library> libraries = adminService.getAllLibraries();
        ActionContext.getContext().put("librariesList", libraries);
        return "LibrariesList";
    }

    public String getLibraryDetails() throws Exception {
        String libraryId = ServletActionContext.getRequest().getParameter("libraryId");
        System.out.println(libraryId);
        Library l = adminService.getLibraryDetails(Integer.parseInt(libraryId));
        ActionContext.getContext().put("library", l);
        return "seeDetails";
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
