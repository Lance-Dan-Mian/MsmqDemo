package com.asl.msmqdemo.common;

/**
 * @author Lance
 * @date 2021/1/7 10:43
 */
public class Result<T> {
    private Integer code;
    private String desc;
    private T data;

    public Result() {
    }

    public Result(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
