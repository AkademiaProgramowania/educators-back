package com.akademia.educators_back.mapper;

import com.akademia.educators_back.to.ProblemTo;
import com.akademia.educators_back.entity.ProblemEntity;
import org.springframework.stereotype.Component;

@Component
public class UpdateProblemMapper {

    public ProblemEntity toUpdateProblemEntity(ProblemTo problemTo){
        ProblemEntity problemEntity = new ProblemEntity();
        if(problemTo != null){
            problemEntity.setId(problemTo.getId());
        }
        problemEntity.setTitle(problemTo.getTitle());
        problemEntity.setQuestion(problemTo.getQuestion());
        return problemEntity;
    }

    public ProblemTo tuUpdateProblemTO(ProblemEntity problemEntity){
        ProblemTo problemTo = new ProblemTo();
        if(problemEntity != null){
            problemTo.setId(problemEntity.getId());
        }
        problemTo.setTitle(problemEntity.getTitle());
        problemTo.setQuestion(problemEntity.getQuestion());
        return problemTo;
    }




}
