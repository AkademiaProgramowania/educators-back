package com.akademia.educators_back.mapper;

import com.akademia.educators_back.entity.ProblemEntity;
import com.akademia.educators_back.to.ProblemTo;
import org.springframework.stereotype.Component;

@Component
public class AddProblemMapper {

    public ProblemEntity toAddProblemEntity(ProblemTo problemTo){
        ProblemEntity problemEntity = new ProblemEntity();
        problemEntity.setTitle(problemTo.getTitle());
        problemEntity.setQuestion(problemTo.getQuestion());
        return problemEntity;
    }

    public ProblemTo toProblemAddTO(ProblemEntity problemEntity){
        ProblemTo problemTo = new ProblemTo();
        problemTo.setTitle(problemEntity.getTitle());
        problemTo.setQuestion(problemEntity.getQuestion());
        return problemTo;
    }
}
