package com.listen.common.vo;

/**
 * FileName GradeOption
 *
 * @author Exler
 * Time 2018-08-30 9:59
 * Description: 选项包装类
 */

public class GradeOption {

    /**
     * 是否是答案 true false
     */
    private Boolean answer;

    /**
     * 选项内容
     */
    private String content;

    public Boolean isAnswer() {
        return answer;
    }

    public void setAnswer(Boolean answer) {
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
                ", answer=" + answer +
                ", content='" + content + '\'' +
                '}';
    }
}
