package com.akademia.educators_back.exception;

public class CommentDoesNotExistException extends RuntimeException{
    public CommentDoesNotExistException(String message){
        super(message);
    }
}
