package com.akademia.educators_back.exception;


public class ProblemDoesNotExistException extends RuntimeException{
    public ProblemDoesNotExistException(String message){
        super(message);
    }
}
