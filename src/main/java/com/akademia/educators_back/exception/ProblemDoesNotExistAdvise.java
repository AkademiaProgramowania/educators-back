package com.akademia.educators_back.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ProblemDoesNotExistAdvise {

    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ProblemDoesNotExistException.class)
    public String exceptionHandler(ProblemDoesNotExistException e){
        return e.getMessage();
    }
}
