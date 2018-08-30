package com.listen.web.action;

import com.listen.domain.Student;
import com.listen.service.StudentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;

/**
 * FileName StudentAction
 * Created by Exler
 * Time 2018-08-30 14:28
 * Description:
 */

public class StudentAction extends ActionSupport implements ModelDriven<Student> {

    private Student student = new Student();
    private StudentService studentService;

    @Override
    public String execute() throws Exception {

        return super.execute();
    }

    /**
     * 登录
     *
     * @return
     * @throws Exception
     */
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
        if (s.getClassify() == 0) {
            ActionContext.getContext().getSession().put("student", s);
            return "toHome";
        } else if (s.getClassify() == 1) {
            ActionContext.getContext().getSession().put("admin", s);
            return "toAdminHome";
        }
        return null;
    }

    /**
     * 注册
     *
     * @return
     * @throws Exception
     */
    public String register() throws Exception {
        try {
            studentService.saveStudent(student);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        return "toLogin";
    }

    /**
     * ajax 检查账号是否存在
     *
     * @return
     * @throws Exception
     */
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

    /**
     * 登出
     *
     * @return
     * @throws Exception
     */
    public String loginOut() throws Exception {
        ActionContext.getContext().getSession().remove("student");
        return "toLogin";
    }

    /**
     * ajax 加载词汇
     *
     * @return
     * @throws Exception
     */
    public String initGrade() throws Exception {
        JSON gradetestJson = studentService.initGradetest();
        ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
        ServletActionContext.getResponse().getWriter().write(gradetestJson.toString());
        return null;
    }

    /**
     * 词汇测试提交等级
     *
     * @return
     * @throws Exception
     */
    public String submitGrade() throws Exception {
        String score = ServletActionContext.getRequest().getParameter("score");
        System.out.println(score);
        Student s = (Student) ActionContext.getContext().getSession().get("student");
        studentService.initGradeCode(s, Float.parseFloat(score));
        return "toHome";
    }

    /**
     * @return
     * @throws Exception
     */
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

    /**
     * ajax 加载听力试卷
     *
     * @return
     * @throws Exception
     */
    public String initSubject() throws Exception {
        String checkId = ServletActionContext.getRequest().getParameter("checkId");
        Student s = (Student) ActionContext.getContext().getSession().get("student");
        String jsonString = studentService.getCurrentCheckPool(s.getGrade(), Integer.parseInt(checkId));
        ServletActionContext.getResponse().setCharacterEncoding("UTF-8");
        ServletActionContext.getResponse().getWriter().write(jsonString);
        System.out.println(jsonString);
        return null;
    }

    /**
     * 提交当前关卡的分数
     *
     * @return
     * @throws Exception
     */
    public String getScore() throws Exception {
        String score = ServletActionContext.getRequest().getParameter("score");
        String checkId = ServletActionContext.getRequest().getParameter("checkId");
        System.out.println("current check point score _______________" + score + "  " + checkId);
        Student s = (Student) ActionContext.getContext().getSession().get("student");
        studentService.saveScore(s.getGrade(), Integer.parseInt(checkId), Integer.parseInt(score), s);
        return "toHome";
    }

    /**
     * 根据当前关卡 分页 返回当前关卡的历史记录
     *
     * @return
     * @throws Exception
     */
    public String getCurrentHistoryList() throws Exception {
        String currentCheck = ServletActionContext.getRequest().getParameter("currentCheck");
        String currentPage = ServletActionContext.getRequest().getParameter("currentPage");
        if (currentPage.equals("") && currentPage == null) {
            currentPage = "0";
        }
        Student stu = (Student) ActionContext.getContext().getSession().get("student");
        JSONObject jsonObject = studentService.getCurrentPageBean(stu, Integer.parseInt(currentPage), Integer.parseInt(currentCheck), 5);
        ServletActionContext.getResponse().getWriter().write(jsonObject.toString());
        return null;
    }

    /**
     * 待实现功能 分页 全部闯关历史记录
     *
     * @return
     * @throws Exception
     */
    public String pageTest() throws Exception {
        String currentPage = ServletActionContext.getRequest().getParameter("currentPage");
        System.out.println(currentPage);
        if (currentPage.equals("") && currentPage == null) {
            currentPage = "0";
        }
        Student stu = (Student) ActionContext.getContext().getSession().get("student");
        JSONObject jsonObject = studentService.getPageBean(stu, Integer.parseInt(currentPage), 5);
        System.out.println(jsonObject);
        return null;
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
