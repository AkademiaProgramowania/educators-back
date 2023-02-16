package com.akademia.educators_back.service;

import com.akademia.educators_back.entity.QuestionEntity;
import com.akademia.educators_back.enums.QuestionCategory;
import com.akademia.educators_back.repository.QuestionRepository;

public class QuestionService {

    QuestionRepository questionRepository;

    public void addQuestionToDB(QuestionEntity question) {
        questionRepository.save(question);
    }

    public void deleteQuestionFromDB(QuestionEntity question) {
        questionRepository.delete(question);
    }

    public void updateQuestion(Long id, String newDescripion, QuestionCategory otherCategory) {
        QuestionEntity questionEntity = questionRepository.findById(id).orElseThrow(NullPointerException::new);
        questionEntity.setDescription(newDescripion);
        questionEntity.setQuestionCategory(otherCategory);
        questionRepository.save(questionEntity);
    }
}