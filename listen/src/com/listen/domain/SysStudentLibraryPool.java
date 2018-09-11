package com.listen.domain;

/**
 * FileName SysStudentLibraryPool
 * @author Exler
 * Time 2018-08-30 10:19
 * Description:
 */
public class SysStudentLibraryPool {

    /**
     * id
     */
    private Integer id;
    /**
     * 做题用户
     * 用户id
     */
    private Student stu;

    /**
     * 对应题库池
     * 题库池id
     */
    private LibraryPool lp;

    /**
     * 所得分数
     */
    private Integer score;

    /**
     * 做题提交的时间
     */
    private String time;

    /**
     * 第几次做题
     */
    private Integer count;

    /**
     * 试卷类别
     * 考试 练习
     */
    private Integer classify;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Student getStu() {
        return stu;
    }

    public void setStu(Student stu) {
        this.stu = stu;
    }

    public LibraryPool getLp() {
        return lp;
    }

    public void setLp(LibraryPool lp) {
        this.lp = lp;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
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

    @Override
    public String toString() {
        return "SysStudentLibraryPool{" +
                "id=" + id +
                ", stu=" + stu.getId() +
                ", lpId=" + lp.getId() +
                ", score=" + score +
                ", time='" + time + '\'' +
                ", count=" + count +
                ", classify=" + classify +
                '}';
    }
}
