package com.akademia.educators_back.exception;

public class ProblemAlreadyExistException extends RuntimeException{
    //TODO konstruktor dostaje parametr ale go nie wykorzystuje
    public ProblemAlreadyExistException(String message) {
        super("This problem already exist");
    }
}
