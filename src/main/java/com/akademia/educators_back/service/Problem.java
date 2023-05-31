package com.akademia.educators_back.service;

import com.akademia.educators_back.to.NewProblemTo;
import com.akademia.educators_back.to.ProblemTo;

import java.util.List;

/**
 * The Problem interface responsible for managing Problem objects
 */
public interface Problem {

    /**
     * Add new Problem object
     * @param newProblemTo
     */
    void addProblem(NewProblemTo newProblemTo);

    /**
     * Delete exist Problem object
     * Throws: IllegalArgumentException – in case the given ids or one of its elements is null.
     * @param problemTo
     */
    void deleteProblem(ProblemTo problemTo);

    /**
     * Update exist Problem object
     * Throws: IllegalArgumentException – in case the given ids or one of is elements is null.
     * @param problemTo
     */
    void updateProblem(ProblemTo problemTo);

    /**
     * Get list of exist Problem objects
     * @return List of exist ProblemTO
     */
    List<ProblemTo> getProblems();

    /**
     * Get single exist Problem object
     * @return exist ProblemTO
     */
    ProblemTo getProblemById(Long id);
}
