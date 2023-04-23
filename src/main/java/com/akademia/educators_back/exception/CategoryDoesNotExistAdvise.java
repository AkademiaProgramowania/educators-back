package com.akademia.educators_back.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class CategoryDoesNotExistAdvise {
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CategoryDoesNotExistException.class)
    public String exceptionHandler(CategoryDoesNotExistException e){
        return e.getMessage();
    }
}
