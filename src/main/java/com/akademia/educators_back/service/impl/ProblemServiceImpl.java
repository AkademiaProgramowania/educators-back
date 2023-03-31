package com.akademia.educators_back.service.impl;

import com.akademia.educators_back.service.Problem;
import com.akademia.educators_back.to.ProblemAddTo;
import com.akademia.educators_back.to.ProblemUpdateTo;
import com.akademia.educators_back.entity.ProblemEntity;
import com.akademia.educators_back.exception.ProblemDoesNotExistException;
import com.akademia.educators_back.mapper.UpdateProblemMapper;
import com.akademia.educators_back.repository.ProblemRepository;
import com.akademia.educators_back.valicators.ProblemValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ProblemServiceImpl implements Problem {
    private ProblemRepository problemRepository;
    private UpdateProblemMapper problemMapper;
    private ProblemValidator problemValidator;

    //TODO RESOLVED to wszystko związane z walidacją wyciągnąć do osobnej metody prywatnej na przykład

    @Override
    public void addProblemToDB(ProblemAddTo problemAddTo) {
        validationMethod(problemAddTo);
        ProblemEntity problemEntity = problemMapper.toUpdateProblemEntity(problemAddTo);
        problemRepository.save(problemEntity);
    }

    @Override
    public void deleteProblemFromDB(ProblemUpdateTo problemTo) {
        validationMethod(problemTo);
        ProblemEntity problemEntity = problemMapper.toUpdateProblemEntity(problemTo);
        problemRepository.delete(problemEntity);
    }

    @Override
    public void updateProblem(ProblemUpdateTo problemTo) {
        validationMethod(problemTo);
        //TODO RESOLVED ta 48 linijka jest nie potrzebna
        ProblemEntity problemEntity;
        problemEntity = problemRepository.findById(problemTo.getId()).orElseThrow(()->new ProblemDoesNotExistException(problemTo.getId()));
        problemEntity.setQuestion(problemTo.getQuestion());
        problemEntity.setTitle(problemTo.getTitle());
        problemEntity.setCategoryEntity(problemTo.getCategoryEntity());
        problemRepository.save(problemEntity);
    }

    @Override
    public List<ProblemUpdateTo> getProblems() {
        List<ProblemUpdateTo> problemsTo = new ArrayList<>();
        List<ProblemEntity> problemsEntity = problemRepository.findAll();
        for (ProblemEntity problem : problemsEntity){
            problemsTo.add(problemMapper.toProblemTO(problem));
        }
        return problemsTo;
    }

    @Override
    public ProblemUpdateTo getProblemById(Long id) {
        ProblemEntity problemEntity = problemRepository.findById(id).orElseThrow(()->new ProblemDoesNotExistException(id));
        return problemMapper.toProblemTO(problemEntity);
    }

    public void validationMethod(ProblemUpdateTo problemTo){
        System.out.println("validators method");
        problemValidator.titleLengthCheck(problemTo);
        problemValidator.questionLengthCheck(problemTo);
        problemValidator.categoryExistCheck(problemTo);
        problemValidator.questionExistCheck(problemTo);
    }


}