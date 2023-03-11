package com.akademia.educators_back.controller;

import com.akademia.educators_back.service.impl.ProblemServiceImpl;
import com.akademia.educators_back.to.ProblemTo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RequestMapping("api/problems")
@RestController
@RequiredArgsConstructor
public class ProblemController {

    public ProblemServiceImpl problemService;

    @GetMapping("/list")
    public ResponseEntity<List<ProblemTo>> getProblems(){
        return ResponseEntity.ok().body(problemService.getProblems());
    }

    @GetMapping("/{id}")
    public ResponseEntity findUserById(@PathVariable Long id){
        ResponseEntity responseEntity;
        try {
            responseEntity = ResponseEntity.ok().body(problemService.getProblemById(id));
        }catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
        return responseEntity;
    }

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void createProblem(@RequestBody ProblemTo problemTo){
        problemService.addProblemToDB(problemTo);
    }
}
