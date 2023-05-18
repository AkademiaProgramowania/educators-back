package com.akademia.educators_back.controller;

import com.akademia.educators_back.exception.ProblemDoesNotExistException;
import com.akademia.educators_back.service.impl.ProblemServiceImpl;
import com.akademia.educators_back.to.NewProblemTo;
import com.akademia.educators_back.to.ProblemTo;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/problems")
@RestController
@AllArgsConstructor
public class ProblemController {

    public ProblemServiceImpl problemService;

    @GetMapping("/list")
    public ResponseEntity<List<ProblemTo>> getProblems(){
        return ResponseEntity.ok().body(problemService.getProblems());
    }

    @GetMapping("/{id}")
    public ProblemTo findProblemById(@PathVariable Long id){
        ProblemTo problemTo;
        try {
            problemTo = problemService.getProblemById(id);
        }catch (ProblemDoesNotExistException e){
            throw new ProblemDoesNotExistException(id);
        }
        return problemTo;
    }


    @PostMapping("/add")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void createProblem(@RequestBody NewProblemTo newProblemTo){
        problemService.addProblem(newProblemTo);
    }
}
