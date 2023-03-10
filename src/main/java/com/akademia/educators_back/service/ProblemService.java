package com.akademia.educators_back.service;

import com.akademia.educators_back.to.ProblemTo;
import com.akademia.educators_back.entity.ProblemEntity;
import com.akademia.educators_back.exception.ProblemDoesNotExistException;
import com.akademia.educators_back.mapper.ProblemMapper;
import com.akademia.educators_back.repository.ProblemRepository;
import org.springframework.stereotype.Service;

@Service
public class ProblemService {

    private ProblemRepository problemRepository;
    private ProblemMapper problemMapper;
    private ProblemEntity problemEntity;

    public void addProblemToDB(ProblemTo problemTo) {
        problemEntity = problemMapper.toProblemEntity(problemTo);
        problemRepository.save(problemEntity);
    }

    public void deleteProblemFromDB(ProblemTo problemTo) {
        problemEntity = problemMapper.toProblemEntity(problemTo);
        problemRepository.delete(problemEntity);
    }

    public void updateProblem(ProblemTo problemTo) {
        problemEntity = problemMapper.toProblemEntity(problemTo);
        problemEntity = problemRepository.findById(problemTo.getId()).orElseThrow(()->new ProblemDoesNotExistException("Problem does not exist"));
        problemEntity.setQuestion(problemTo.getQuestion());
        problemEntity.setTitle(problemTo.getTitle());
        problemEntity.setCategoryEntity(problemTo.getCategoryEntity());
        problemRepository.save(problemEntity);
    }
}