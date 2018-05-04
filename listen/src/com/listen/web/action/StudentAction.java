package com.listen.web.action;

import com.listen.domain.Student;
import com.listen.service.StudentService;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import net.sf.json.JSON;
import org.apache.struts2.ServletActionContext;

import java.util.PrimitiveIterator;
import java.util.UUID;

public class StudentAction extends ActionSupport implements ModelDriven<Student> {

    private Student student = new Student();
    private StudentService studentService;

    public String login() throws Exception {
        // classify 判断是否是学生 教师 管理员
        Student s;
        try {
            s = studentService.findStudentById(student);
        } catch (Exception e) {
            e.printStackTrace();
            ActionContext.getContext().put("error", e.getMessage());
            return "login";
        }
        System.out.println(s);
        ActionContext.getContext().getSession().put("student", s);
        return "toHome";
    }

    public String register() throws Exception {
        try {
            studentService.saveStudent(student);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        return "toLogin";
    }

    public String checkAccount() throws Exception {
        String account = ServletActionContext.getRequest().getParameter("account");
        try {
            System.out.println(account);
            studentService.findStudentByAccount(account);
        } catch (Exception e) {
            e.printStackTrace();
            ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
            ServletActionContext.getResponse().getWriter().write(e.getMessage());
        }
        return null;
    }

    public String loginOut() throws Exception {
        ActionContext.getContext().getSession().remove("student");
        return "toLogin";
    }

    public String initGrade() throws Exception {
        JSON gradetestJson = studentService.initGradetest();
        ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
        ServletActionContext.getResponse().getWriter().write(gradetestJson.toString());
        return null;
    }

    public String submitGrade() throws Exception {
        String score = ServletActionContext.getRequest().getParameter("score");
        System.out.println(score);
        Student s = (Student) ActionContext.getContext().getSession().get("student");
        studentService.initGradeCode(s, Integer.parseInt(score));
        return "toHome";
    }

    public String clearance() throws Exception {
        String checkcount = ServletActionContext.getRequest().getParameter("checkcount");
        Student s = (Student) ActionContext.getContext().getSession().get("student");
        try {
            studentService.openNewCheckPoint(s, checkcount);
            return "";
        } catch (Exception e) {
            return "";
        }
    }

    public String initSubject() throws Exception {
        String checkId = ServletActionContext.getRequest().getParameter("checkId");
        Student s = (Student) ActionContext.getContext().getSession().get("student");
        String jsonString = studentService.getCurrentCheckPool(s.getGrade(), Integer.parseInt(checkId));
        ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
        ServletActionContext.getResponse().getWriter().write(jsonString);
        return "toSubject";
    }

    public String getScore() throws Exception {
        String score = ServletActionContext.getRequest().getParameter("score");
        String checkId = ServletActionContext.getRequest().getParameter("checkId");
        Student s = (Student) ActionContext.getContext().getSession().get("student");
        studentService.saveScore(s.getGrade(), Integer.parseInt(checkId), Integer.parseInt(score), s);
        return "toHome";
    }

    public StudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(StudentService studentService) {
        this.studentService = studentService;
    }

    @Override
    public Student getModel() {
        return student;
    }
}
