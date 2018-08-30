package com.listen.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * FileName Student
 * Created by Exler
 * Time 2018-08-30 10:10
 * Description: 用户类
 */

public class Student {

    /**
     * 用户id
     */
    private Integer id;

    /**
     * 用户姓名
     */
    private String name;

    /**
     * 用户账号
     */
    private String account;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户所处等级
     */
    private Integer grade;

    /**
     * 用户类别
     */
    private Integer classify;    // 0 学生 1 教师 2 管理员

    /**
     * 用户所处当前关卡
     */
    private Integer currentCheck;

    /**
     * 用户与做题记录表对应 sysStudentLibraryPool
     */
    private Set<SysStudentLibraryPool> sysStudentLibraryPoolSet = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getClassify() {
        return classify;
    }

    public void setClassify(Integer classify) {
        this.classify = classify;
    }

    public Integer getCurrentCheck() {
        return currentCheck;
    }

    public void setCurrentCheck(Integer currentCheck) {
        this.currentCheck = currentCheck;
    }

    public Set<SysStudentLibraryPool> getSysStudentLibraryPoolSet() {
        return sysStudentLibraryPoolSet;
    }

    public void setSysStudentLibraryPoolSet(Set<SysStudentLibraryPool> sysStudentLibraryPoolSet) {
        this.sysStudentLibraryPoolSet = sysStudentLibraryPoolSet;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", grade=" + grade +
                ", classify=" + classify +
                ", currentCheck=" + currentCheck +
                '}';
    }
}
