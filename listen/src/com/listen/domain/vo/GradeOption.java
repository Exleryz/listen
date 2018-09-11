package com.listen.domain.vo;

/**
 * FileName GradeOption
 * Created by Exler
 * Time 2018-08-30 9:59
 * Description: 选项包装类
 */
public class GradeOption {
    /**
     * 题目序号 0 1 2 3
     */
    private int sort;
    /**
     * 是否是答案 true false
     */
    private boolean answer;
    /**
     * 选项内容
     */
    private String content;

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Option{" +
                "sort=" + sort +
                ", answer=" + answer +
                ", content='" + content + '\'' +
                '}';
    }
}
