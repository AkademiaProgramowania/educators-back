package com.akademia.educators_back.controller;

import com.akademia.educators_back.service.ProblemService;
import com.akademia.educators_back.to.ProblemTo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProblemController {

    private ProblemService problemService;

    public ProblemController(ProblemService problemService) {
        this.problemService = problemService;
    }

    @GetMapping("/api/users")
    public ResponseEntity<List<ProblemTo>> getProblems(){
        return ResponseEntity.ok()
                .body(problemService.getProblems());
    }

    @PostMapping("/api/users")
    public void createProblem(@RequestBody ProblemTo problemTo){
        System.out.println(problemTo);
        problemService.addProblemToDB(problemTo);
    }

}
