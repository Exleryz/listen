package com.listen.pojo;

import com.github.pagehelper.PageInfo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * FileName SysUserLibraryPool
 *
 * @author Exler
 * Time 2018-08-30 10:19
 * Description:
 */

@Table(name = "SysUserLibraryPool")
public class SysUserLibraryPool extends PageInfo<SysUserLibraryPool> {

    /**
     * id
     */
    @Id
    @Column(name = "id")
    private Integer id;


    /**
     * 对应题库池
     * 题库池id
     */
    @Column(name = "lpId")
    private Integer lpId;

    /**
     * 所得分数
     */
    @Column(name = "score")
    private Double score;

    /**
     * 做题提交的时间
     */
    @Column(name = "time")
    private String time;

    /**
     * 第几次做题
     */
    @Column(name = "count")
    private Integer count;

    /**
     * 试卷类别
     * 考试 练习
     */
    @Column(name = "classify")
    private Integer classify;

    /**
     * 做题用户
     * 用户id
     */
    @Column(name = "userId")
    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLpId() {
        return lpId;
    }

    public void setLpId(Integer lpId) {
        this.lpId = lpId;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getClassify() {
        return classify;
    }

    public void setClassify(Integer classify) {
        this.classify = classify;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "SysUserLibraryPool{" +
                "id=" + id +
                ", lpId=" + lpId +
                ", score=" + score +
                ", time='" + time + '\'' +
                ", count=" + count +
                ", classify=" + classify +
                ", userId=" + userId +
                '}';
    }
}
