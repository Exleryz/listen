package com.listen.domain.vo;

import com.listen.domain.SysStudentLibraryPool;

/**
 * FileName SysStudentLibraryPoolVo
 * @author Exler
 * Time 2018-08-31 16:23
 * Description: SysStudentLibraryPool包装类
 */

public class QuerySysStudentLibraryPoolVo extends SysStudentLibraryPool {

    /**
     * 学生姓名
     */
    private String studentName;

    /**
     * 学号
     */
    private String studentAccount;

    /**
     * 分数操作符
     */
    private String scoreOperator;

    /**
     * 时间戳
     */
    private String timeStart;

    private String timeEnd;

    /**
     * 等级
     */
    private Integer grade;

    /**
     * 关数
     */
    private Integer check;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentAccount() {
        return studentAccount;
    }

    public void setStudentAccount(String studentAccount) {
        this.studentAccount = studentAccount;
    }

    public String getScoreOperator() {
        return scoreOperator;
    }

    public void setScoreOperator(String scoreOperator) {
        this.scoreOperator = scoreOperator;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getCheck() {
        return check;
    }

    public void setCheck(Integer check) {
        this.check = check;
    }
}
