package com.akademia.educators_back.service;

import com.akademia.educators_back.to.ProblemTo;
import com.akademia.educators_back.entity.ProblemEntity;
import com.akademia.educators_back.exception.ProblemDoesNotExistException;
import com.akademia.educators_back.mapper.ProblemMapper;
import com.akademia.educators_back.repository.ProblemRepository;
import com.akademia.educators_back.to.UserTo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProblemService {

    private ProblemRepository problemRepository;
    private ProblemMapper problemMapper;

    public ProblemService(ProblemRepository problemRepository, ProblemMapper problemMapper) {
        this.problemRepository = problemRepository;
        this.problemMapper = problemMapper;
    }

    public void addProblemToDB(ProblemTo problemTo) {
        problemRepository.save(problemMapper.toProblemEntity(problemTo));
        //problemEntity = problemMapper.toProblemEntity(problemTo);
        //problemRepository.save(problemEntity);
    }

    public void deleteProblemFromDB(ProblemTo problemTo) {
        problemRepository.delete(problemMapper.toProblemEntity(problemTo));
        //problemEntity = problemMapper.toProblemEntity(problemTo);
        //problemRepository.delete(problemEntity);
    }

    public void updateProblem2(ProblemTo problemTo){
        ProblemEntity problemEntity1;
        problemEntity1 = problemMapper.toProblemEntity(problemTo);
        problemEntity1 = problemRepository.findById(problemTo.getId()).orElseThrow(()->new ProblemDoesNotExistException("Problem does not exist"));
        problemEntity1.setQuestion(problemTo.getQuestion());
        problemEntity1.setTitle(problemTo.getTitle());
        problemEntity1.setCategoryEntity(problemTo.getCategoryEntity());
        problemRepository.save(problemEntity1);
    }

    public List<ProblemTo> getProblems(){
        List<ProblemTo> problemTo = new ArrayList<>();
        List<ProblemEntity> problems = problemRepository.findAll();
        for (ProblemEntity problem : problems) {
            problemTo.add(problemMapper.toProblemTO(problem));
        }
        return problemTo;
    }
}