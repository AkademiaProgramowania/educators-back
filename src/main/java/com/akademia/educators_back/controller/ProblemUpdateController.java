package com.akademia.educators_back.controller;

import com.akademia.educators_back.service.impl.ProblemServiceImpl;
import com.akademia.educators_back.to.ProblemTo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping("api/problems")
@RestController
@AllArgsConstructor
public class ProblemUpdateController {

    public ProblemServiceImpl problemService;
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void createProblem(@RequestBody ProblemTo problemTo){
        problemService.updateProblem(problemTo);
    }
}
