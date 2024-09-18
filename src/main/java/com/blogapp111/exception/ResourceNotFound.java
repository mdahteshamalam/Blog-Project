package com.blogapp111.exception;

public class ResourceNotFound extends RuntimeException{
    public ResourceNotFound(String message){
        super(message);
    }
}
