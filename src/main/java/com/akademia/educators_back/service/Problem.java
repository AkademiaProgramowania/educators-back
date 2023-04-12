package com.akademia.educators_back.service;

import com.akademia.educators_back.to.NewProblemTo;
import com.akademia.educators_back.to.ProblemTo;

import java.util.List;

public interface Problem {
    void addProblem(NewProblemTo newProblemTo);
    void deleteProblem(ProblemTo problemTo);
    void updateProblem(ProblemTo problemTo);
    List<ProblemTo> getProblems();

    ProblemTo getProblemById(Long id);
}
