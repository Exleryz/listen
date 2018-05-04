package com.listen.domain;

public class Vocabulary {
    private Integer id;
    private String chinese;
    private String english;
    private String explain1;
    private String explain2;
    private String explain3;
    private Integer grade;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChinese() {
        return chinese;
    }

    public void setChinese(String chinese) {
        this.chinese = chinese;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getExplain1() {
        return explain1;
    }

    public void setExplain1(String explain1) {
        this.explain1 = explain1;
    }

    public String getExplain2() {
        return explain2;
    }

    public void setExplain2(String explain2) {
        this.explain2 = explain2;
    }

    public String getExplain3() {
        return explain3;
    }

    public void setExplain3(String explain3) {
        this.explain3 = explain3;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Vocabulary{" +
                "id=" + id +
                ", chinese='" + chinese + '\'' +
                ", english='" + english + '\'' +
                ", explain1='" + explain1 + '\'' +
                ", explain2='" + explain2 + '\'' +
                ", explain3='" + explain3 + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
