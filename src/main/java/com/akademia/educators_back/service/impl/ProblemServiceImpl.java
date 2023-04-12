package com.akademia.educators_back.service.impl;

import com.akademia.educators_back.mapper.ProblemMapper;
import com.akademia.educators_back.service.Problem;
import com.akademia.educators_back.to.ProblemTo;
import com.akademia.educators_back.entity.ProblemEntity;
import com.akademia.educators_back.exception.ProblemDoesNotExistException;
import com.akademia.educators_back.mapper.UpdateProblemMapper;
import com.akademia.educators_back.repository.ProblemRepository;
import lombok.AllArgsConstructor;
import com.akademia.educators_back.valicators.ProblemValidator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProblemServiceImpl implements Problem {
    private ProblemRepository problemRepository;
    private UpdateProblemMapper updateProblemMapper;
    private ProblemMapper problemMapper;
    private ProblemValidator problemValidator;

    @Override
    public void addProblemToDB(ProblemTo problemTo) {
        validationMethod(problemTo);
        ProblemEntity problemEntity = problemMapper.toProblemEntity(problemTo);
        problemRepository.save(problemEntity);
    }

    @Override
    public void deleteProblemFromDB(ProblemTo problemTo) {
        validationMethod(problemTo);
        ProblemEntity problemEntity = updateProblemMapper.toUpdateProblemEntity(problemTo);
        problemRepository.delete(problemEntity);
    }

    @Override
    public void updateProblem(ProblemTo problemTo) {
        validationMethod(problemTo);
        ProblemEntity problemEntity;
        problemEntity = problemRepository.findById(problemTo.getId()).orElseThrow(()->new ProblemDoesNotExistException(problemTo.getId()));
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
        ProblemEntity problemEntity = problemRepository.findById(id).orElseThrow(()->new ProblemDoesNotExistException(id));
        return problemMapper.toProblemTO(problemEntity);
    }

    public void validationMethod(ProblemTo problemTo){
        System.out.println("validators method");
        problemValidator.titleLengthCheck(problemTo);
        problemValidator.questionLengthCheck(problemTo);
        problemValidator.categoryExistCheck(problemTo);
        problemValidator.questionExistCheck(problemTo);
    }


}