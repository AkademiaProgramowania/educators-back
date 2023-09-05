package com.akademia.educators_back.mapper;

import com.akademia.educators_back.entity.ProblemEntity;
import com.akademia.educators_back.to.NewProblemTo;
import com.akademia.educators_back.to.ProblemTo;
import com.openapi.gen.springboot.to.ProblemOpenApiTo;
import org.springframework.stereotype.Component;

/**
 * Class for mapping problem transfer object and problem entity
 */
@Component
public class ProblemMapper {

    /**
     * Map problem object into new problem transfer object
     * @param newProblemTo New problem TO is an object without ID representing a new problem
     * @return problem entity
     */
    public ProblemEntity toProblemEntity(NewProblemTo newProblemTo){
        ProblemEntity problemEntity = new ProblemEntity();
        problemEntity.setTitle(newProblemTo.getTitle());
        problemEntity.setQuestion(newProblemTo.getQuestion());
        return problemEntity;
    }

    /**
     * Map new problem TO object into problem entity
     * @param problemEntity Problem entity representing a problem
     * @return new problem TO
     */
    public NewProblemTo toNewProblemTo(ProblemEntity problemEntity){
        NewProblemTo newProblemTo = new NewProblemTo();
        newProblemTo.setTitle(problemEntity.getTitle());
        newProblemTo.setQuestion(problemEntity.getQuestion());
        newProblemTo.setCategoryName(problemEntity.getCategoryEntity().getCategoryName());
        return newProblemTo;
    }

    /**
     * Map problem transfer object object into problem entity
     * @param problemTo Problem TO is an object with ID representing a problem
     * @return problem entity
     */
    public ProblemEntity toProblemEntity(ProblemTo problemTo){
        ProblemEntity problemEntity = new ProblemEntity();
        if(problemTo != null){
            problemEntity.setId(problemTo.getId());
        }
        problemEntity.setTitle(problemTo.getTitle());
        problemEntity.setQuestion(problemTo.getQuestion());
        return problemEntity;
    }

    /**
     * Map problem entity into problem transfer object
     * @param problemEntity Problem entity representing a problem
     * @return problem TO
     */
    public ProblemTo toProblemTo(ProblemEntity problemEntity){
        ProblemTo problemTo = new ProblemTo();
        if(problemEntity != null){
            problemTo.setId(problemEntity.getId());
        }
        problemTo.setTitle(problemEntity.getTitle());
        problemTo.setQuestion(problemEntity.getQuestion());
        problemTo.setCategoryName(problemEntity.getCategoryEntity().getCategoryName());
        return problemTo;
    }

    public ProblemOpenApiTo toProblemOpenApiTo(ProblemTo problemTo){
        ProblemOpenApiTo problemOpenApiTo = new ProblemOpenApiTo();
        if(problemTo != null){
            problemOpenApiTo.setId(String.valueOf(problemTo.getId()));
        }
        problemOpenApiTo.setTitle(problemTo.getTitle());
        problemOpenApiTo.setQuestion(problemTo.getQuestion());
        return problemOpenApiTo;
    }


}
