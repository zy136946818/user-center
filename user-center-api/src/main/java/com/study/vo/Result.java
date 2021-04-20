package com.study.vo;

import java.io.Serializable;

/**
 * @author zhangyu
 */
public class Result<T> implements Serializable {
    private static final long serialVersionUID = -6478327438363182007L;
    public static final String CODE_SUCCESS = "0";
    public static final String CODE_SUCCESS_MESSAGE = "success";
    public static final String CODE_FAIL = "500";
    public static final String CODE_FAIL_MESSAGE = "服务器异常";
    public static final String CODE_PARAMS_ERROR = "10000";
    private boolean success = true;
    private String code = "0";
    private String message = "";
    private T data;

    private Result() {
    }

    private Result(boolean success, String code, String msg, T data) {
        this.success = success;
        this.code = code;
        this.message = msg;
        this.data = data;
    }

    private Result(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> Result paramsError() {
        Result result = new Result("10000", "请求参数错误", (Object)null);
        return result;
    }

    public static <T> Result success() {
        Result result = new Result("0", "success", (Object)null);
        return result;
    }

    public static <T> Result success(String message) {
        Result result = new Result(true, "0", message, (Object)null);
        return result;
    }

    public static <T> Result success(T data) {
        Result result = new Result(true, "0", "success", data);
        return result;
    }

    public static <T> Result success(String code, String msg) {
        Result result = new Result(true, code, msg, (Object)null);
        return result;
    }

    public static Result fail(String code, String errorMsg) {
        Result result = new Result(false, code, errorMsg, (Object)null);
        return result;
    }

    public static <T> Result fail(String code, String errorMsg, T data) {
        Result result = new Result(false, code, errorMsg, data);
        return result;
    }

    public static <T> Result fail(T data) {
        Result result = new Result(false, "500", "服务器异常", data);
        return result;
    }

    public static Result fail(String errorMsg) {
        return fail("1", errorMsg);
    }

    public static <T> Result data(T data) {
        Result result = new Result(true, "0", "", data);
        return result;
    }

    public static <T> Result data(String code, String msg, T data) {
        Result result = new Result(true, code, msg, data);
        return result;
    }

    public String getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.message;
    }

    public T getData() {
        return this.data;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return this.success;
    }
}
