package com.akademia.educators_back.valicators;

import com.akademia.educators_back.exception.CategoryDoesNotExistException;
import com.akademia.educators_back.exception.ProblemAlreadyExistException;
import com.akademia.educators_back.exception.TextLengthException;
import com.akademia.educators_back.repository.ProblemRepository;
import com.akademia.educators_back.to.NewProblemTo;
import com.akademia.educators_back.to.ProblemTo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Component to validate problem data
 */
@Component
@AllArgsConstructor
public class ProblemValidator {

    /** Static value for minimum title lenght */
    private final int MIN_TITLE_LENGTH = 3;

    /** Static value for maximum title lenght */
    private final int MAX_TITLE_LENGTH = 100;

    /** Static value for minimum question length */
    private final int MIN_QUESTION_LENGTH = 10;

    /** Static value for maximum question length */
    private final int MAX_QUESTION_LENGTH = 1000;
    private ProblemRepository problemRepository;


    /**
     * Performs validation on the problem data.
     *
     * @param problemTo problem TO is an object with ID representing a problem
     */
    public void validExistProblem(ProblemTo problemTo){
        titleLengthCheck(problemTo);
        questionLengthCheck(problemTo);
        categoryExistCheck(problemTo);
        questionExistCheck(problemTo);
    }
    /**
     * Performs validation on the new problem data.
     *
     * @param newProblemTo New problem TO is an object without ID representing a new problem
     */
    public void validNewProblem(NewProblemTo newProblemTo){
        titleLengthCheck(newProblemTo);
        questionLengthCheck(newProblemTo);
        categoryExistCheck(newProblemTo);
        questionExistCheck(newProblemTo);
    }

    /**
     * Check if the category of new problem exist
     * @param newProblemTo New problem TO is an object without ID representing a new problem
     */
    private void categoryExistCheck(NewProblemTo newProblemTo) {
        if (!problemRepository.existsByCategoryEntity_CategoryName(newProblemTo.getCategoryName())) {
            throw new CategoryDoesNotExistException(newProblemTo.getCategoryName());
        }
    }

    /**
     * Check if the question of new problem exist
     * @param newProblemTo New problem TO is an object without ID representing a new problem
     */
    private void questionExistCheck(NewProblemTo newProblemTo) {
        if (problemRepository.existsByQuestion(newProblemTo.getQuestion())) {
            throw new ProblemAlreadyExistException(newProblemTo.getQuestion());
        }
    }

    /**
     * Check if the title of new problem has correct length
     * @param newProblemTo New problem TO is an object without ID representing a new problem
     */
    private void titleLengthCheck(NewProblemTo newProblemTo) {
        int titleLength = newProblemTo.getTitle().length();
        if (titleLength < MIN_TITLE_LENGTH || titleLength > MAX_TITLE_LENGTH) {
            throw new TextLengthException("Provided title has incorrect length");
        }
    }

    /**
     * Check if the question of new problem has correct lenght
     * @param newProblemTo New problem TO is an object without ID representing a new problem
     */
    private void questionLengthCheck(NewProblemTo newProblemTo) {
        int questionLength = newProblemTo.getQuestion().length();
        if (questionLength < MIN_QUESTION_LENGTH || questionLength > MAX_QUESTION_LENGTH) {
            throw new TextLengthException("Provided question has incorrect length");
        }
    }

    /**
     * Check if the category of exist problem exist
     * @param problemTo problem TO is an object with ID representing a problem
     */
    private void categoryExistCheck(ProblemTo problemTo) {
        if (!problemRepository.existsByCategoryEntity_CategoryName(problemTo.getCategoryEntity().getCategoryName())) {
            throw new CategoryDoesNotExistException(problemTo.getCategoryEntity().getCategoryName());
        }
    }

    /**
     * Check if the question exist new problem exist
     * @param problemTo problem TO is an object with ID representing a problem
     */
    private void questionExistCheck(ProblemTo problemTo) {
        if (problemRepository.existsByQuestion(problemTo.getQuestion())) {
            throw new ProblemAlreadyExistException(problemTo.getQuestion());
        }
    }

    /**
     * Check if the title of exist problem has correct length
     * @param problemTo problem TO is an object with ID representing a problem
     */
    private void titleLengthCheck(ProblemTo problemTo) {
        int titleLength = problemTo.getTitle().length();
        if (titleLength < MIN_TITLE_LENGTH || titleLength > MAX_TITLE_LENGTH) {
            throw new TextLengthException("Provided title has incorrect length");
        }
    }

    /**
     * Check if the question of exist problem has correct lenght
     * @param problemTo problem TO is an object with ID representing a problem
     */
    private void questionLengthCheck(ProblemTo problemTo) {
        int questionLength = problemTo.getQuestion().length();
        if (questionLength < MIN_QUESTION_LENGTH || questionLength > MAX_QUESTION_LENGTH) {
            throw new TextLengthException("Provided question has incorrect length");
        }
    }

}


