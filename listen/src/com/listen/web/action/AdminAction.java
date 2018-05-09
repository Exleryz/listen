package com.listen.web.action;

import com.listen.domain.Student;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class AdminAction extends ActionSupport implements ModelDriven<Student> {

    private Student admin = new Student();

    @Override
    public Student getModel() {
        return admin;
    }
}
