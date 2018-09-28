package com.listen.common.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.List;

/**
 * FileName GradeSubject
 *
 * @author Exler
 * Time 2018-08-30 10:03
 * Description: 题目包装类
 * https://blog.csdn.net/ls13219681990/article/details/81740990
 * 忽略null值空字段
 */

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class GradeSubject {

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
    private Integer grade;

    /**
     * 题目序号
     */
    private Integer sort;

    /**
     * 题目解析
     */
    private String analysis;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<GradeOption> getOptions() {
        return options;
    }

    public void setOptions(List<GradeOption> options) {
        this.options = options;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getAnalysis() {
        return analysis;
    }

    public void setAnalysis(String analysis) {
        this.analysis = analysis;
    }

    @Override
    public String toString() {
        return "GradeSubject{" +
                "question='" + question + '\'' +
                ", grade=" + grade +
                ", sort=" + sort +
                ", analysis='" + analysis + '\'' +
                '}';
    }
}



