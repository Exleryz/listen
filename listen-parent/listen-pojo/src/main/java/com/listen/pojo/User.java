package com.listen.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * FileName User
 *
 * @author Exler
 * Time 2018-08-30 10:10
 * Description: 用户类
 */

@Table(name = "User")
public class User {

    /**
     * 用户id
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 用户姓名
     */
    @Column(name = "username")
    private String username;

    /**
     * 用户账号
     */
    @Column(name = "account")
    private String account;

    /**
     * 密码
     */
    @Column(name = "password")
    private String password;

    /**
     * 盐
     */
    @Column(name = "salt")
    private String salt;

    /**
     * 用户所处等级 0还未进行单词测试
     */
    @Column(name = "grade")
    private Integer grade;

    /**
     * 用户类别
     * 0 学生 1 教师 2 管理员
     */
    @Column(name = "classify")
    private Integer classify;

    /**
     * 用户所处当前关卡
     */
    @Column(name = "currentCheck")
    private Integer currentCheck;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
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

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", grade=" + grade +
                ", classify=" + classify +
                ", currentCheck=" + currentCheck +
                '}';
    }
}
