package com.group.ecommerce.Dto.Base;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"code", "status", "message", "data", "timestamp"})
public class Response {
    private String code;
    private String status;
    private String message;
    private Object data;
    private Long timestamp;

    private Response(String code, String status, String message, Object data) {
        this.code = code;
        this.status = status;
        this.message = message;
        this.data = data;
        this.timestamp = System.currentTimeMillis();
    }

    private Response(String code, String status, String message) {
        this.code = code;
        this.status = status;
        this.message = message;
        this.timestamp = System.currentTimeMillis();
    }

    public static Response success(String status, String message) {
        return new Response("200", status, message);
    }

    public static  Response success(String code, String status, String message){
        return new Response(code, status, message);
    }

    public static Response success(String code, String status, String message, Object data){
        return new Response(code, status, message, data);
    }

    public static Response fail(String code, String status, String message){
        return new Response(code, status, message);
    }

    public static Response fail(String code, String status, String message, Object data){
        return new Response(code, status, message, data);
    }

    public static Response error(String status, String message){
        return new Response("500", status, message);
    }

    public static Response badRequest(String status, String message, Object data){
        return new Response("400", status, message, data);
    }
}
