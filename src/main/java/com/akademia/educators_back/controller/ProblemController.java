package com.akademia.educators_back.controller;

import com.akademia.educators_back.exception.ProblemDoesNotExistException;
import com.akademia.educators_back.service.impl.ProblemServiceImpl;
import com.akademia.educators_back.to.NewProblemTo;
import com.akademia.educators_back.to.ProblemTo;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for handling request od problems.
 */
@RequestMapping("api/problems")
@RestController
@AllArgsConstructor
public class ProblemController {

    public ProblemServiceImpl problemService;

    /**
     * Controller to problem list.
     * @return response entity
     */
    @GetMapping("/list")
    public ResponseEntity<List<ProblemTo>> getProblems(){
        return ResponseEntity.ok().body(problemService.getProblems());
    }

    /**
     * Cotroller to get single problem with provided param.
     * @param id ID is unique number which represent every one problem.
     * @return The ProblemTo witch unique ID
     * @throws Exception when there in no problem which provided ID.
     */
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

    /**
     * Controller to create a new problem
     * @param newProblemTo The NewProblemTo is an object representing the new Problem.
     */
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void createProblem(@RequestBody NewProblemTo newProblemTo){
        problemService.addProblem(newProblemTo);
    }
}
