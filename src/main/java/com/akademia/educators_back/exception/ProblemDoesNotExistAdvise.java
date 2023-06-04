package com.akademia.educators_back.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Class for handling exceptions when there is no such problem
 */
@ControllerAdvice
public class ProblemDoesNotExistAdvise {

    /**
     Exception handler for ProblemDoesNotExistException
     * @param e the ProblemDoesNotExistException instance
     * @return message associated with the exception
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProblemDoesNotExistException.class)
    public String exceptionHandler(ProblemDoesNotExistException e){
        return e.getMessage();
    }
}
