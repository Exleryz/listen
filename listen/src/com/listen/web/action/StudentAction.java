package com.listen.web.action;

import com.listen.domain.Student;
import com.listen.domain.SysStudentLibraryPool;
import com.listen.service.StudentService;

import com.listen.utils.PageBean;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import net.sf.json.JSON;
import org.apache.struts2.ServletActionContext;

import java.util.List;
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
        ActionContext.getContext().getSession().put("student", s);
        if (s.getClassify() == 0) {
            return "toHome";
        } else if (s.getClassify() == 1) {
            return "toTeacherHome";
        }
        return null;
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

    @Deprecated
    public String getList() throws Exception {
        Student stu = (Student) ActionContext.getContext().getSession().get("student");
        List<SysStudentLibraryPool> list = studentService.getlist(stu);
        ActionContext.getContext().put("stulp", list);
//        return "historyList";
        return null;
    }

    public String pageTest() throws Exception {
        String currentPage = ServletActionContext.getRequest().getParameter("currentPage");
        if (currentPage.equals("") && currentPage == null) {
            currentPage = "0";
        }
        Student stu = (Student) ActionContext.getContext().getSession().get("student");
        PageBean pb = studentService.getPageBean(stu, Integer.parseInt(currentPage), 5);
        ActionContext.getContext().put("pageBean", pb);
        return "showList";
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
