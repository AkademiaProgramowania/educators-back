package com.akademia.educators_back.service;

import com.akademia.educators_back.to.ProblemTo;

import java.util.List;

public interface Problem {
    void addProblemToDB(ProblemTo problemTo);
    void deleteProblemFromDB(ProblemTo problemTo);
    void updateProblem(ProblemTo problemTo);
    List<ProblemTo> getProblems();

    ProblemTo getProblemById(Long id);
}
