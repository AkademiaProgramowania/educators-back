package com.akademia.educators_back.mapper;

import com.akademia.educators_back.entity.ProblemEntity;
import com.akademia.educators_back.to.NewProblemTo;
import com.akademia.educators_back.to.ProblemTo;
import org.springframework.stereotype.Component;

@Component
public class ProblemMapper {


    public ProblemEntity toProblemEntity(NewProblemTo newProblemTo){
        ProblemEntity problemEntity = new ProblemEntity();
        problemEntity.setTitle(newProblemTo.getTitle());
        problemEntity.setQuestion(newProblemTo.getQuestion());
        return problemEntity;
    }

    public ProblemEntity toProblemEntity(ProblemTo problemTo){
        ProblemEntity problemEntity = new ProblemEntity();
        if(problemTo != null){
            problemEntity.setId(problemTo.getId());
        }
        problemEntity.setTitle(problemTo.getTitle());
        problemEntity.setQuestion(problemTo.getQuestion());
        return problemEntity;
    }

    public ProblemTo toProblemTO(ProblemEntity problemEntity){
        ProblemTo problemTo = new ProblemTo();
        if(problemEntity != null){
            problemTo.setId(problemEntity.getId());
        }
        problemTo.setTitle(problemEntity.getTitle());
        problemTo.setQuestion(problemEntity.getQuestion());
        return problemTo;
    }
}
