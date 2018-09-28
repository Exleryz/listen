package com.listen.common.utils;

/**
 * @author Exler
 * @FileName ListenResult
 * @time 2018-09-11 11:02
 * @Description:
 */
public class ListenResult {

    private String msg;
    /**
     * 1 error
     * 10 账号密码错误
     * 200 OK
     */
    private Integer code;
    private Object data;

    public ListenResult() {

    }

    public ListenResult(String msg, Integer code, Object data) {
        if (code != null) {
            this.setCode(code);
        }
        if (data != null) {
            this.setData(data);
        }
        if (msg != null) {
            this.setMsg(msg);
        }
    }

    public static ListenResult success(Object data) {
        return new ListenResult("success", 200, data);
    }

    public static ListenResult error(String msg) {
        return new ListenResult(msg, 1, null);
    }

    public ListenResult makeInternalErrorResult() {
        return new ListenResult("内部错误", 11, null);
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
