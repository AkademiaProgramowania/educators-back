package com.akademia.educators_back.valicators;

import com.akademia.educators_back.exception.CategoryDoesNotExistException;
import com.akademia.educators_back.exception.ProblemAlreadyExistException;
import com.akademia.educators_back.exception.TextLengthException;
import com.akademia.educators_back.mapper.UpdateProblemMapper;
import com.akademia.educators_back.repository.ProblemRepository;
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

    //TODO RESOLVED nie ma konstruktora więc się wywali przy wywołaniu -

    //TODO RESOLVED po co to zwracać, nie lepiej boolean albo void?
    public void categoryExistCheck(ProblemTo problemTo) {
        if (!problemRepository.existsByCategoryEntity_CategoryName(problemTo.getCategoryEntity().getCategoryName())) {
            throw new CategoryDoesNotExistException(problemTo.getCategoryEntity().getCategoryName());
        }
    }

    //TODO RESOLVED po co to zwracać, nie lepiej boolean?
    public void questionExistCheck(ProblemTo problemTo) {
        if (!problemRepository.existsByQuestion(problemTo.getQuestion())) {
            throw new ProblemAlreadyExistException(problemTo.getQuestion());
        }
    }


    //TODO RESOLVED ta metoda nie musi nic zwracać

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

    //TODO RESOLVED dwa "ing" obok siebie trochę dziwnie się czyta,
    // proponuję problemCategoryCheck lub nawet categoryCheck -
    // w paramter metody wsadzamy problemTo więc można się
    // łatwo domyśleć że problemu dotyczy, dodatkowo wywołujemy ProblemValidator
    // w aktualnej formie mamy w jednej linijce aż 3 razy problem (w serwisie ProblemServiceImpl)
    // problemValidator.problemCategoryExistingChecking(problemTo);
    // ta sama uwaga dotyczy wszystkich metod tutaj, spróbuj uprościć :)

    //TODO RESOLVED Tego typu "zahardkodowane" wartości lepiej wyciągnąć do stałych pól chociaż, może być w tym serwisie póki co.
    // i problemTo.getTitle().length() też bym wyciągnął do zmiennej ale już w samej metodzie



