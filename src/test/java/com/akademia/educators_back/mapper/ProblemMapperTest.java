package com.akademia.educators_back.mapper;

import com.akademia.educators_back.entity.CategoryEntity;
import com.akademia.educators_back.entity.ProblemEntity;
import com.akademia.educators_back.mapper.ProblemMapper;
import com.akademia.educators_back.to.NewProblemTo;
import com.akademia.educators_back.to.ProblemTo;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
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
        NewProblemTo newProblemTo = new NewProblemTo();
        newProblemTo.setTitle(TITLE);
        newProblemTo.setQuestion(QUESTION);

        ProblemEntity problemEntity = problemMapper.toProblemEntity(newProblemTo);

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
        ProblemTo problemTo = new ProblemTo();
        problemTo.setId(1L);
        problemTo.setTitle(TITLE);
        problemTo.setQuestion(QUESTION);

        ProblemEntity problemEntity = problemMapper.toProblemEntity(problemTo);

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

        ProblemTo problemTo = problemMapper.toProblemTO(problemEntity);

        assertEquals(Long.valueOf(1L), problemTo.getId());
        assertEquals(TITLE, problemTo.getTitle());
        assertEquals(QUESTION, problemTo.getQuestion());
        assertEquals(categoryEntity, problemTo.getCategoryEntity());
    }
//    @Test
//    void toNewProblemTOWhenProblemEntityIsNull() {
//        ProblemEntity problemEntity = null;
//
//        NewProblemTo newProblemTo = problemMapper.toNewProblemTO(problemEntity);
//
//        assertNull(newProblemTo);
//    }
}