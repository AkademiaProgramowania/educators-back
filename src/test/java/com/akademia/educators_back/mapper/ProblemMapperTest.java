package com.akademia.educators_back.mapper;

import com.akademia.educators_back.entity.CategoryEntity;
import com.akademia.educators_back.entity.ProblemEntity;
import com.akademia.educators_back.to.NewProblemTo;
import com.akademia.educators_back.to.ProblemTo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class ProblemMapperTest {

    private final String TITLE = "Title";
    private final String QUESTION = "Question";
    private final String CATEGORY_NAME = "Category";

    @Autowired
    private ProblemMapper problemMapper;

    @Test
    void toProblemEntityWithNewProblemToArgument() {
        //when
        ProblemEntity problemEntity = problemMapper.toProblemEntity(generateNewProblemTo());

        //then
        assertEquals(TITLE, problemEntity.getTitle());
        assertEquals(QUESTION, problemEntity.getQuestion());
    }
//TODO czy potrzebny jest tutaj test sprawdzający co się stanie jak posa się w Entity id
    @Test
    void toNewProblemTO() {
        ProblemEntity problemEntity = new ProblemEntity();
        problemEntity.setTitle(TITLE);
        problemEntity.setQuestion(QUESTION);
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryName(CATEGORY_NAME);
        problemEntity.setCategoryEntity(categoryEntity);

        NewProblemTo newProblemTo = problemMapper.toNewProblemTO(problemEntity);

        assertEquals(TITLE, newProblemTo.getTitle());
        assertEquals(QUESTION, newProblemTo.getQuestion());
        assertEquals(CATEGORY_NAME, newProblemTo.getCategoryName());
    }

    @Test
    void toProblemEntityWithProblemToArgument() {
        //when
        ProblemEntity problemEntity = problemMapper.toProblemEntity(generateProblemTo());

        //then
        assertEquals(Long.valueOf(1L), problemEntity.getId());
        assertEquals(TITLE, problemEntity.getTitle());
        assertEquals(QUESTION, problemEntity.getQuestion());
    }

    @Test
    void toProblemTO() {
        ProblemEntity problemEntity = new ProblemEntity();
        problemEntity.setId(1L);
        problemEntity.setTitle(TITLE);
        problemEntity.setQuestion(QUESTION);
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryName(CATEGORY_NAME);
        problemEntity.setCategoryEntity(categoryEntity);

        ProblemTo problemTo = problemMapper.toProblemTO(generateProblemEntity());

        assertEquals(Long.valueOf(1L), problemTo.getId());
        assertEquals(TITLE, problemTo.getTitle());
        assertEquals(QUESTION, problemTo.getQuestion());
        assertEquals(categoryEntity, problemTo.getCategoryEntity());
    }

    private ProblemTo generateProblemTo(){
        return ProblemTo.builder()
                .id(1L)
                .title(TITLE)
                .question(QUESTION)
                .build();
    }

    private NewProblemTo generateNewProblemTo(){
        return NewProblemTo.builder()
                .title(TITLE)
                .question(QUESTION)
                .build();
    }

    private ProblemEntity generateProblemEntity(){
        return ProblemEntity.builder()
                .id(1L)
                .title(TITLE)
                .question(QUESTION)
                .categoryEntity(generateCategoryEntity())
                .build();
    }

    private CategoryEntity generateCategoryEntity(){
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryName(CATEGORY_NAME);
        return categoryEntity;
    }
//    void toNewProblemTOWhenProblemEntityIsNull() {
//        ProblemEntity problemEntity = null;
//
//        NewProblemTo newProblemTo = problemMapper.toNewProblemTO(problemEntity);
//
//        assertNull(newProblemTo);
//    }
}