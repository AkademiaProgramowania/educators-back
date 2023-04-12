package com.akademia.educators_back.exception;

public class ProblemAlreadyExistException extends RuntimeException{
    public ProblemAlreadyExistException(String message) {
        super("This problem already exist");
    }
}
