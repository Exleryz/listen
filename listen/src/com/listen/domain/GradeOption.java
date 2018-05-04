package com.listen.domain;

public class GradeOption {
    private int sort;    // 0 1 2 3
    private boolean answer;    // true false
    private String content;    // XXXXXXXXXXXXXXXXXXXXX

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
