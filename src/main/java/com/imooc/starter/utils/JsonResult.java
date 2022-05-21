package com.imooc.starter.utils;

/**
 * Created by ZhangXinmin on zhangxinmin.
 * Copyright (c) 2022 . All rights reserved.
 * 本类可用于H5/Android/IOS/公众号/小程序
 * 200：表示请求成功；
 * 500：表示错误，不管多少个错误都是以map返回
 * 501：bean验证错误，不管多少个错误都以map返回
 * 502：拦截器拦截到用户token出错
 * 555：异常抛出信息
 */
public class JsonResult {
    //响应状态
    private Integer code;

    //响应消息
    private String msg;

    //响应中的数据
    private Object data;

    public JsonResult() {
    }

    public JsonResult(Integer status, String msg, Object data) {
        this.code = status;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public static JsonResult build(Integer status, String msg, Object data) {
        return new JsonResult(status, msg, data);
    }

    public static JsonResult success( Object data) {
        return new JsonResult(200, "success", data);
    }

    public static JsonResult error(Integer status, String msg, Object data) {
        return new JsonResult(status, msg, null);
    }
}
