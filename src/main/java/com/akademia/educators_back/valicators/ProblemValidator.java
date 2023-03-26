package com.akademia.educators_back.valicators;

import com.akademia.educators_back.exception.CategoryDoesNotExistException;
import com.akademia.educators_back.mapper.ProblemMapper;
import com.akademia.educators_back.repository.ProblemRepository;
import com.akademia.educators_back.to.ProblemTo;
import org.springframework.stereotype.Component;

@Component
public class ProblemValidator {

    private ProblemRepository problemRepository;
    private ProblemMapper problemMapper;


    public ProblemTo ProblemCategoryExistingChecking(ProblemTo problemTo){
        if(!problemRepository.existsByCategoryEntity_CategoryName(problemTo.getCategoryEntity().getCategoryName())) {
            throw new CategoryDoesNotExistException(problemTo.getCategoryEntity().getCategoryName());
        }
            return problemTo;
    }

    public ProblemTo problemQuestionExistingChecking(ProblemTo problemTo){
        if(!problemRepository.existsByQuestion(problemTo.getQuestion())){
            //todo dodac wyjatek
        }
        return problemTo;
    }

    //todo DODAĆ TRZECIĄ METODĘ WALIDACJI

    public ProblemTo problemTitleLengthChecking(ProblemTo problemTo){
        if(problemTo.getTitle().length() < 3 || problemTo.getTitle().length() > 100) {
            //todo dodac wyjatek
        }
        return problemTo;
    }

    //todo DODAĆ czwartą METODĘ WALIDACJI
    public ProblemTo problemQuestionLengthChecking(ProblemTo problemTo) {
        if (problemTo.getQuestion().length() < 10 || problemTo.getTitle().length() > 1000) {
            //todo dodac wyjatek
        }
        return problemTo;
    }
}



