package com.listen.domain;

public class SysStudentLibraryPool {
    private Integer id;
    private Student stu;
    private LibraryPool lp;
    private Integer score;
    private String time;
    private Integer count;
    private Integer classify;    // 考试 练习

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
