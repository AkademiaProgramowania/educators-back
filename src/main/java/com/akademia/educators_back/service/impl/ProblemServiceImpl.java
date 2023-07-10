package com.akademia.educators_back.service.impl;

import com.akademia.educators_back.entity.CategoryEntity;
import com.akademia.educators_back.mapper.ProblemMapper;
import com.akademia.educators_back.repository.CategoryRepository;
import com.akademia.educators_back.service.Problem;
import com.akademia.educators_back.to.NewProblemTo;
import com.akademia.educators_back.to.ProblemTo;
import com.akademia.educators_back.entity.ProblemEntity;
import com.akademia.educators_back.exception.ProblemDoesNotExistException;
import com.akademia.educators_back.repository.ProblemRepository;
import lombok.AllArgsConstructor;
import com.akademia.educators_back.validator.ProblemValidator;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service for handling problem
 */
@Service
@AllArgsConstructor
public class ProblemServiceImpl implements Problem {

    private ProblemRepository problemRepository;
    private ProblemMapper problemMapper;
    private ProblemValidator problemValidator;
    private CategoryRepository categoryRepository;

    /**
     * Add new problem
     * @param newProblemTo New problem TO is an object without ID representing a new problem
     */
    @Override
    public void addProblem(NewProblemTo newProblemTo) {
        problemValidator.validNewProblem(newProblemTo);
        ProblemEntity problemEntity = problemMapper.toProblemEntity(newProblemTo);
        CategoryEntity categoryEntity = findCategoryEntity(newProblemTo.getCategoryName());
        problemEntity.setCategoryEntity(categoryEntity);
        problemRepository.save(problemEntity);
    }

    /**
     * Delete exist problem
     * @param problemTo problem TO is an object with ID representing a problem
     */
    @Override
    public void deleteProblem(ProblemTo problemTo) {
        problemValidator.validExistProblem(problemTo);
        ProblemEntity problemEntity = problemMapper.toProblemEntity(problemTo);
        problemRepository.delete(problemEntity);
    }

    /**
     * Update exist problem
     * Throws: ProblemDoesNotExistException when problem with given id does not exist
     * @param problemTo problem TO is an object with ID representing a problem
     */
    @Override
    public void updateProblem(ProblemTo problemTo) {
        problemValidator.validExistProblem(problemTo);
        ProblemEntity problemEntity;
        problemEntity = problemRepository.findById(problemTo.getId()).orElseThrow(()->new ProblemDoesNotExistException(problemTo.getId()));
        problemEntity.setQuestion(problemTo.getQuestion());
        problemEntity.setTitle(problemTo.getTitle());
        CategoryEntity categoryEntity = findCategoryEntity(problemTo.getCategoryName());
        problemEntity.setCategoryEntity(categoryEntity);
        problemRepository.save(problemEntity);
    }

    /**
     * Get list of exist problem
     */
    @Override
    public List<ProblemTo> getProblems() {
        List<ProblemTo> problemsTo = new ArrayList<>();
        List<ProblemEntity> problemsEntity = problemRepository.findAll();
        for (ProblemEntity problem : problemsEntity){
            problemsTo.add(problemMapper.toProblemTo(problem));
        }
        return problemsTo;
    }

    /**
     * Get single problem with provided param.
     * Throws: ProblemDoesNotExistException when problem with given id does not exist
     * @param id ID is unique number which represent every one problem.
     */
    @Override
    public ProblemTo getProblemById(Long id) {
        ProblemEntity problemEntity = problemRepository.findById(id).orElseThrow(()->new ProblemDoesNotExistException(id));
        return problemMapper.toProblemTo(problemEntity);
    }

    private CategoryEntity findCategoryEntity(String categoryName){
        CategoryEntity categoryEntity = categoryRepository.getCategoryEntityByCategoryName(categoryName);
        return categoryEntity;
    }
}