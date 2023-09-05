package com.akademia.educators_back.controller;

import com.akademia.educators_back.exception.ProblemDoesNotExistException;
import com.akademia.educators_back.service.impl.ProblemServiceImpl;
import com.akademia.educators_back.to.NewProblemTo;
import com.akademia.educators_back.to.ProblemTo;
import com.openapi.gen.springboot.api.ProblemsApiDelegate;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller for handling request on Problems object.
 */
@RequestMapping("api/problems")
@RestController
@AllArgsConstructor
public class ProblemController implements ProblemsApiDelegate {

    

    private static final Logger LOG = LoggerFactory.getLogger(ProblemController.class);
    public ProblemServiceImpl problemService;

    /**
     * Controller responsible for sending list of all Problem objects.
     * @return response entity
     */
    @GetMapping("/list")
    public ResponseEntity<List<ProblemTo>> getProblems(){
        return ResponseEntity.ok().body(problemService.getProblems());
    }

    /**
     * Cotroller responsible for get single Problem with provided param.
     * @param id ID is unique number which represent every one problem.
     * @return The ProblemTo witch unique ID
     * @throws Exception when there is no problem which provided ID.
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
     * Controller responsible for create a new Problem object
     * @param newProblemTo The NewProblemTo is an object representing the new problem.
     */
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void createProblem(@RequestBody @Valid NewProblemTo newProblemTo){
        LOG.info("Request to add a new problem has been received");
        problemService.addProblem(newProblemTo);
    }

    /**
     * Controller responsible for update exist Problem
     * @param problemTo The ProblemTo is an object representing exist problem.
     */
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.ACCEPTED)
    void changeExistingProblem(@RequestBody ProblemTo problemTo){
        problemService.updateProblem(problemTo);
    }
}
