package com.mine.manager.entity;

/**
 * @author xujie
 */
public class Result<T> {

    private int code;
    private T data;
    private int count;

    public Result(T data) {
        this.code = 0;
        this.data = data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCode() {
        return code;
    }

    public T getData() {
        return data;
    }

    public int getCount() {
        return count;
    }
    /*@Override
    public String toString() {
        return JSON.toJSONString(this);
    }*/
}
