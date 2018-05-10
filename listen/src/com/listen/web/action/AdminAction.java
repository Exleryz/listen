package com.listen.web.action;

import com.listen.domain.Student;
import com.listen.service.AdminService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminAction extends ActionSupport implements ModelDriven<Student> {

    private Student admin = new Student();
    private AdminService adminService;

    public String getCurrentScoreSet() throws Exception {

        return null;
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
