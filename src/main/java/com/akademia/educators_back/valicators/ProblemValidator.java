package com.akademia.educators_back.valicators;

import com.akademia.educators_back.exception.CategoryDoesNotExistException;
import com.akademia.educators_back.exception.ProblemAlreadyExistException;
import com.akademia.educators_back.exception.TextLengthException;
import com.akademia.educators_back.mapper.UpdateProblemMapper;
import com.akademia.educators_back.repository.ProblemRepository;
import com.akademia.educators_back.to.NewProblemTo;
import com.akademia.educators_back.to.ProblemTo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ProblemValidator {

    private final int MIN_TITLE_LENGTH = 3;
    private final int MAX_TITLE_LENGTH = 100;
    private final int MIN_QUESTION_LENGTH = 10;
    private final int MAX_QUESTION_LENGTH = 1000;
    private ProblemRepository problemRepository;

    public void categoryExistCheck(NewProblemTo newProblemTo) {
        if (!problemRepository.existsByCategoryEntity_CategoryName(newProblemTo.getCategoryEntity().getCategoryName())) {
            throw new CategoryDoesNotExistException(newProblemTo.getCategoryEntity().getCategoryName());
        }
    }

    public void questionExistCheck(NewProblemTo newProblemTo) {
        if (!problemRepository.existsByQuestion(newProblemTo.getQuestion())) {
            throw new ProblemAlreadyExistException(newProblemTo.getQuestion());
        }
    }

    public void titleLengthCheck(NewProblemTo newProblemTo) {
        int titleLength = newProblemTo.getTitle().length();
        if (titleLength < MIN_TITLE_LENGTH || titleLength > MAX_TITLE_LENGTH) {
            throw new TextLengthException("Provided title has incorrect length");
        }
    }

    public void questionLengthCheck(NewProblemTo newProblemTo) {
        int questionLength = newProblemTo.getQuestion().length();
        if (questionLength < MIN_QUESTION_LENGTH || questionLength > MAX_QUESTION_LENGTH) {
            throw new TextLengthException("Provided question has incorrect length");
        }
    }

    public void categoryExistCheck(ProblemTo problemTo) {
        if (!problemRepository.existsByCategoryEntity_CategoryName(problemTo.getCategoryEntity().getCategoryName())) {
            throw new CategoryDoesNotExistException(problemTo.getCategoryEntity().getCategoryName());
        }
    }

    public void questionExistCheck(ProblemTo problemTo) {
        if (!problemRepository.existsByQuestion(problemTo.getQuestion())) {
            throw new ProblemAlreadyExistException(problemTo.getQuestion());
        }
    }

    public void titleLengthCheck(ProblemTo problemTo) {
        int titleLength = problemTo.getTitle().length();
        if (titleLength < MIN_TITLE_LENGTH || titleLength > MAX_TITLE_LENGTH) {
            throw new TextLengthException("Provided title has incorrect length");
        }
    }

    public void questionLengthCheck(ProblemTo problemTo) {
        int questionLength = problemTo.getQuestion().length();
        if (questionLength < MIN_QUESTION_LENGTH || questionLength > MAX_QUESTION_LENGTH) {
            throw new TextLengthException("Provided question has incorrect length");
        }
    }
}


