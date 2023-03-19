package com.akademia.educators_back.exception;


public class ProblemDoesNotExistException extends RuntimeException{
    public ProblemDoesNotExistException(long id){
        super("Poblem with id: " + id + " not exist" );
    }
}
