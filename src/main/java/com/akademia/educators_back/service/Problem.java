package com.akademia.educators_back.service;

import com.akademia.educators_back.to.NewProblemTo;
import com.akademia.educators_back.to.ProblemTo;

import java.util.List;

public interface Problem {

    /**
     * Add new problem
     * @param newProblemTo
     */
    void addProblem(NewProblemTo newProblemTo);

    /**
     * Delete exist problem
     * Throws: IllegalArgumentException – in case the given ids or one of its elements is null.
     * @param problemTo
     */
    void deleteProblem(ProblemTo problemTo);

    /**
     * Update exist problem
     * Throws: IllegalArgumentException – in case the given ids or one of is elements is null.
     * @param problemTo
     */
    void updateProblem(ProblemTo problemTo);

    /**
     * Get list of problems exist problem
     * @return List of exist problemTO
     */
    List<ProblemTo> getProblems();

    /**
     * Get single exist problem
     * @return exist problemTO
     */
    ProblemTo getProblemById(Long id);
}
