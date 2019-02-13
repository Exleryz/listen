package com.listen.common.utils;

/**
 * @author Exler
 * @FileName ListenResult
 * @time 2018-09-11 11:02
 * @Description:
 */
public class ListenResult {

    private String msg;

    private boolean flag;

    private Object data;

    public ListenResult() {

    }

    public ListenResult(String msg, boolean flag, Object data) {
        this.setFlag(flag);
        this.setData(data);
        this.setMsg(msg);
    }

    public ListenResult(String msg, Integer code, boolean flag, Object data) {
        this.msg = msg;
        this.flag = flag;
        this.data = data;
    }

    public static ListenResult success(Object data) {
        return new ListenResult("success", 200, true, data);
    }

    public static ListenResult error(String msg) {
        return new ListenResult(msg, 1, false, null);
    }

    public ListenResult makeInternalErrorResult() {
        return new ListenResult("内部错误", 11, false, null);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
