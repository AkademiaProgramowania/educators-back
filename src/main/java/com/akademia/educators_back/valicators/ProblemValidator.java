package com.akademia.educators_back.valicators;

import com.akademia.educators_back.entity.CategoryEntity;
import com.akademia.educators_back.entity.ProblemEntity;
import com.akademia.educators_back.exception.CategoryDoesNotExistException;
import com.akademia.educators_back.exception.ProblemDoesNotExistException;
import com.akademia.educators_back.mapper.ProblemMapper;
import com.akademia.educators_back.repository.ProblemRepository;
import com.akademia.educators_back.to.ProblemTo;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
public class ProblemValidator {

    private ProblemRepository problemRepository;
    private ProblemMapper problemMapper;


    public ProblemTo categoryExistingChecking(ProblemTo problemTo){
        if(!problemRepository.existsByCategoryEntity_CategoryName(problemTo.getCategoryEntity().getCategoryName())) {
            throw new CategoryDoesNotExistException(problemTo.getCategoryEntity().getCategoryName());
        }
            return problemTo;
    }

    public ProblemTo questionExistingChecking(ProblemTo problemTo){
        if(!problemRepository.existsByQuestion(problemTo.getQuestion())){
            //todo dodac wyjatek
        }
        return problemTo;
    }
}



