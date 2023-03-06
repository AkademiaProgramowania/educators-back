package com.akademia.educators_back.controller;

import com.akademia.educators_back.service.impl.ProblemService;
import com.akademia.educators_back.to.ProblemTo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RequestMapping("api/problems")
@RestController
@RequiredArgsConstructor
public class ProblemController {

    public ProblemService problemService;

    @GetMapping("/api/problemsList")
    public ResponseEntity<List<ProblemTo>> getProblems(){
        return ResponseEntity.ok().body(problemService.getProblems());
    }

    @GetMapping("/api/problem/{id}")
    public ResponseEntity<ProblemTo> findUserById(@PathVariable Long id){
        try {
            return ResponseEntity.ok().body(problemService.getProblemById(id));
        }catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/api/addProblem")
    void createProblem(@RequestBody ProblemTo problemTo){
        problemService.addProblemToDB(problemTo);
    }
}
