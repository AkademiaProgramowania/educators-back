package com.akademia.educators_back.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Class for handling exceptions related to existing problems
 */
@ControllerAdvice
public class ProblemAdvise {

    /**
     * Exception handler for ProblemAlreadyExistException
     * @param e the ProblemAlreadyExistException instance
     * @return message associated with the exception
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ProblemAlreadyExistException.class)
    public String problemAlreadyExistExceptionHandler(ProblemAlreadyExistException e){
        return e.getMessage();
    }

    /**
     Exception handler for ProblemDoesNotExistException
     * @param e the ProblemDoesNotExistException instance
     * @return message associated with the exception
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProblemDoesNotExistException.class)
    public String problemDoesNotExistExceptionHandler(ProblemDoesNotExistException e){
        return e.getMessage();
    }
}
