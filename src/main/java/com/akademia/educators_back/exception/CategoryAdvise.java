package com.akademia.educators_back.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * Class for handling exceptions related to existing category
 */
@ControllerAdvice
public class CategoryAdvise {

    /**
     * Exception handler for CategoryAlreadyExistException
     * @param e the CategoryAlreadyExistException instance
     * @return message associated with the exception
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(CategoryAlreadyExistException.class)
    public String categoryAlreadyExistExceptionHandler(CategoryAlreadyExistException e){
        return e.getMessage();
    }

    /**
     * Exception handler for CategoryDoesNotExistException
     * @param e the CategoryDoesNotExistException instance
     * @return message associated with the exception
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(CategoryDoesNotExistException.class)
    public String categoryDoesNotExistExceptionHandler(CategoryDoesNotExistException e){
        return e.getMessage();
    }

}
