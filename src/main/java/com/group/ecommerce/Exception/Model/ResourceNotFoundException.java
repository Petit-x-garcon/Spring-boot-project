package com.group.ecommerce.Exception.Model;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String messsage){
        super(messsage);
    }
}
