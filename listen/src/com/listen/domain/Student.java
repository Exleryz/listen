package com.listen.domain;

import java.util.HashSet;
import java.util.Set;

public class Student {

    private Integer id;
    private String name;
    private String account;
    private String password;
    private Integer grade;
    private Integer classify;    // 0 学生 1 教师 2 管理员
    private Integer currentCheck;

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
