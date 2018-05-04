package com.listen.domain;

import java.util.List;

public class GradeSubject {
    private int count;
    private String question;
    private List<GradeOption> options;
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
