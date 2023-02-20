package com.akademia.educators_back.service;

import com.akademia.educators_back.entity.ProblemEntity;
import com.akademia.educators_back.repository.ProblemRepository;
import org.springframework.stereotype.Service;

@Service
public class ProblemService {

    ProblemRepository problemRepository;

    public void addProblemToDB(ProblemEntity problem) {
        problemRepository.save(problem);
    }

    public void deleteProblemFromDB(ProblemEntity problem) {
        problemRepository.delete(problem);
    }

    public void updateProblem(Long id, String newTitle, String newQuestion) {
        ProblemEntity questionEntity = problemRepository.findById(id).orElseThrow(NullPointerException::new);
        questionEntity.setTitle(newTitle);
        questionEntity.setQuestion(newQuestion);
        problemRepository.save(questionEntity);
    }
}