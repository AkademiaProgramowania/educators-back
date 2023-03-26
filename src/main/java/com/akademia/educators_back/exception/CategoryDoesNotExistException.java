package com.akademia.educators_back.exception;

public class CategoryDoesNotExistException extends RuntimeException{

    public CategoryDoesNotExistException(String name) {
        super("Category " + name + " does not exist" );
    }
}