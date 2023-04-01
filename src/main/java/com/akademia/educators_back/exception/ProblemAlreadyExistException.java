package com.akademia.educators_back.exception;

public class ProblemAlreadyExistException extends RuntimeException{
    //TODO RESOLVED konstruktor dostaje parametr ale go nie wykorzystuje
    public ProblemAlreadyExistException(String message) {
        super("Problem " + message + " already exist");
    }
}
