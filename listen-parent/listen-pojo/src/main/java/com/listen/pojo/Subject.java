package com.listen.pojo;

import com.github.pagehelper.PageInfo;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * FileName Subject
 *
 * @author Exler
 * Time 2018-08-30 10:14
 * Description: 小题类
 * 一个大题目包含个数不定的小题
 */

@Table(name = "Subject")
public class Subject extends PageInfo<Subject> {

    /**
     * 小题id
     */
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * 答案
     */
    @Column(name = "answer")
    private Character answer;

    /**
     * 选项A内容
     */
    @Column(name = "optionA")
    private String optionA;

    /**
     * 选项B内容
     */
    @Column(name = "optionB")
    private String optionB;

    /**
     * 选项C内容
     */
    @Column(name = "optionC")
    private String optionC;

    /**
     * 选项D内容
     */
    @Column(name = "optionD")
    private String optionD;

    /**
     * 当前题目在大题中的排序
     */
    @Column(name = "sort")
    private Integer sort;

    /**
     * 当前题目的解析
     */
    @Column(name = "analysis")
    private String analysis;

    /**
     * 大题
     * library的id
     */
    @Column(name = "libraryId")
    private Integer libraryId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Character getAnswer() {
        return answer;
    }

    public void setAnswer(Character answer) {
        this.answer = answer;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
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

    public Integer getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Integer libraryId) {
        this.libraryId = libraryId;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", answer=" + answer +
                ", optionA='" + optionA + '\'' +
                ", optionB='" + optionB + '\'' +
                ", optionC='" + optionC + '\'' +
                ", optionD='" + optionD + '\'' +
                ", sort=" + sort +
                ", analysis='" + analysis + '\'' +
                ", libraryId=" + libraryId +
                '}';
    }
}