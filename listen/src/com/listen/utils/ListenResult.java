package com.listen.utils;

/**
 * @author Exler
 * @FileName ListenResult
 * @time 2018-09-11 11:02
 * @Description:
 */
public class ListenResult {

    private String msg;
    private Integer code;
    private Object data;

    public ListenResult() {

    }

    public ListenResult(String msg, Integer code, Object data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public ListenResult makeResult(Integer code, String message, Object data) {
        if (code != null) {
            this.setCode(code);
        }

        if (data != null) {
            this.setData(data);
        }

        if (message != null) {
            this.setMsg(message);
        }

        return this;
    }

    public ListenResult makeInternalErrorResult() {
        return this.makeResult(11, "内部错误", (Object)null);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
