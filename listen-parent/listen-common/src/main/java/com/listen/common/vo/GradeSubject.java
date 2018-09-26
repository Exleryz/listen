package com.listen.common.vo;

import java.util.List;

/**
 * FileName GradeSubject
 * Created by Exler
 * Time 2018-08-30 10:03
 * Description: 题目包装类
 */

public class GradeSubject {
    /**
     * 子题数
     */
    private int count;
    /**
     * 题目问题
     */
    private String question;
    /**
     * 题目选项
     */
    private List<GradeOption> options;
    /**
     * 题目等级
     */
    private int grade;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<GradeOption> getOptions() {
        return options;
    }

    public void setOptions(List<GradeOption> options) {
        this.options = options;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "count=" + count +
                ", options=" + options +
                '}';
    }
}

