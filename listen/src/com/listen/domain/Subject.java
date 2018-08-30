package com.listen.domain;

/**
 * FileName Subject
 * Created by Exler
 * Time 2018-08-30 10:14
 * Description: 小题类
 * 一个大题目包含个数不定的小题
 */

public class Subject {

    /**
     * 小题id
     */
    private Integer id;

    /**
     * 大题
     * library的id
     */
    private Library library;

    /**
     * 答案
     */
    private Character answer;

    /**
     * 选项A内容
     */
    private String optionA;

    /**
     * 选项B内容
     */
    private String optionB;

    /**
     * 选项C内容
     */
    private String optionC;

    /**
     * 选项D内容
     */
    private String optionD;

    /**
     * 当前题目在大题中的排序
     */
    private Integer sort;

    /**
     * 当前题目的解析
     */
    private String analysis;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
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

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", library=" + library +
                ", answer=" + answer +
                ", optionA='" + optionA + '\'' +
                ", optionB='" + optionB + '\'' +
                ", optionC='" + optionC + '\'' +
                ", optionD='" + optionD + '\'' +
                ", sort=" + sort +
                ", analysis='" + analysis + '\'' +
                '}';
    }
}

