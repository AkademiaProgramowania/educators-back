package com.akademia.educators_back.exception;

public class CategoryDoesNotExistException extends RuntimeException{

    public CategoryDoesNotExistException(String name) {
        super("Category " + name + " does not exist" );
    }

    public CategoryDoesNotExistException(long id) {
        super("Category with id: " + id + " not exist"  );
    }
}
