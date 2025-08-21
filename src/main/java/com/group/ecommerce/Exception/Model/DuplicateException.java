package com.group.ecommerce.Exception.Model;

public class DuplicateException extends RuntimeException{
    public DuplicateException(String message){
        super(message);
    }
}
