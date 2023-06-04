package com.akademia.educators_back.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Class for handling exceptions related to existing problems
 */
public class ProblemAlreadyExistAdvise {

    /**
     * Exception handler for ProblemAlreadyExistException
     * @param e the ProblemAlreadyExistException instance
     * @return message associated with the exception
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ProblemAlreadyExistException.class)
    public String exceptionHandler(ProblemAlreadyExistException e){
        return e.getMessage();
    }
}
