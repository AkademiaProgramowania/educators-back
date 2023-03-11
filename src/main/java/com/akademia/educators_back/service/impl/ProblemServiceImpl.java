package com.akademia.educators_back.service.impl;

import com.akademia.educators_back.service.Problem;
import com.akademia.educators_back.to.ProblemTo;
import com.akademia.educators_back.entity.ProblemEntity;
import com.akademia.educators_back.exception.ProblemDoesNotExistException;
import com.akademia.educators_back.mapper.ProblemMapper;
import com.akademia.educators_back.repository.ProblemRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProblemServiceImpl implements Problem {

    private ProblemRepository problemRepository;
    private ProblemMapper problemMapper;
    private ProblemEntity problemEntity;
    @Override
    public void addProblemToDB(ProblemTo problemTo) {
        problemEntity = problemMapper.toProblemEntity(problemTo);
        problemRepository.save(problemEntity);
    }

    @Override
    public void deleteProblemFromDB(ProblemTo problemTo) {
        problemEntity = problemMapper.toProblemEntity(problemTo);
        problemRepository.delete(problemEntity);
    }

    @Override
    public void updateProblem(ProblemTo problemTo) {
        problemEntity = problemMapper.toProblemEntity(problemTo);
        problemEntity = problemRepository.findById(problemTo.getId()).orElseThrow(()->new ProblemDoesNotExistException("Problem does not exist"));
        problemEntity.setQuestion(problemTo.getQuestion());
        problemEntity.setTitle(problemTo.getTitle());
        problemEntity.setCategoryEntity(problemTo.getCategoryEntity());
        problemRepository.save(problemEntity);
    }

    @Override
    public List<ProblemTo> getProblems() {
        List<ProblemTo> problemsTo = new ArrayList<>();
        List<ProblemEntity> problemsEntity = problemRepository.findAll();
        for (ProblemEntity problem : problemsEntity){
            problemsTo.add(problemMapper.toProblemTO(problem));
        }
        return problemsTo;
    }

    @Override
    public ProblemTo getProblemById(Long id) {
        problemEntity = problemRepository.findById(id).orElseThrow(()->new ProblemDoesNotExistException("Problem does not exist"));
        return problemMapper.toProblemTO(problemEntity);
    }
}