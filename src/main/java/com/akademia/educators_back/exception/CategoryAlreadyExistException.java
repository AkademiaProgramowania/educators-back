package com.akademia.educators_back.exception;

public class CategoryAlreadyExistException extends RuntimeException{
    public CategoryAlreadyExistException(String message) {
        super("Category " + message + " already exist");
    }
}
