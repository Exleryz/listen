package com.listen.pojo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Exler
 * 积分表
 */
@Table(name = "Integral")
public class Integral {

    /**
     * 积分id
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 获取积分的用户id
     */
    @Column(name = "userId")
    private Integer userId;

    /**
     * 获取的积分数量
     */
    @Column(name = "num")
    private Integer num;

    /**
     * 获取积分的时间
     */
    @Column(name = "getTime")
    private String getTime;

    /**
     * 获取积分的方式
     */
    @Column(name = "getWay")
    private String getWay;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getGetTime() {
        return getTime;
    }

    public void setGetTime(String getTime) {
        this.getTime = getTime;
    }

    public String getGetWay() {
        return getWay;
    }

    public void setGetWay(String getWay) {
        this.getWay = getWay;
    }

    @Override
    public String toString() {
        return "Integral{" +
                "id=" + id +
                ", userId=" + userId +
                ", num=" + num +
                ", getTime='" + getTime + '\'' +
                ", getWay='" + getWay + '\'' +
                '}';
    }
}
