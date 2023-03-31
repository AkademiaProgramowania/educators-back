package com.akademia.educators_back.service;

import com.akademia.educators_back.to.ProblemUpdateTo;

import java.util.List;

public interface Problem {
    void addProblemToDB(ProblemUpdateTo problemTo);
    void deleteProblemFromDB(ProblemUpdateTo problemTo);
    void updateProblem(ProblemUpdateTo problemTo);
    List<ProblemUpdateTo> getProblems();

    ProblemUpdateTo getProblemById(Long id);
}
