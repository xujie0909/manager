package com.mine.manager.common;

import lombok.Data;

/**
 * @author xujie
 */
@Data
public class Response<T> {
    private Integer code;
    private String msg;
    private T data;

    public Response(T data) {
        this.code = 200;
        this.msg = "";
        this.data = data;
    }

    public Response(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Response() {
    }
}
