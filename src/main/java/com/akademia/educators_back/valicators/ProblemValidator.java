package com.akademia.educators_back.valicators;

import com.akademia.educators_back.entity.CategoryEntity;
import com.akademia.educators_back.entity.ProblemEntity;
import com.akademia.educators_back.exception.ProblemDoesNotExistException;
import com.akademia.educators_back.mapper.ProblemMapper;
import com.akademia.educators_back.repository.ProblemRepository;
import com.akademia.educators_back.to.ProblemTo;


public class ProblemValidator {

    private ProblemRepository problemRepository;
    private ProblemMapper problemMapper;


    public ProblemTo categoryExistingChecking(ProblemEntity problemEntity){
        if(!problemRepository.findByCategoryEntity_CategoryName(problemEntity.getCategoryEntity().getCategoryName())) {
            //TODO dodać wyjątek
        }
            return problemMapper.toProblemTO(problemEntity);
        }



}



