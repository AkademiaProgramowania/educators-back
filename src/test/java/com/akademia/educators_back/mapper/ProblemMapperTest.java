package com.akademia.educators_back.mapper;

import com.akademia.educators_back.entity.CategoryEntity;
import com.akademia.educators_back.entity.ProblemEntity;
import com.akademia.educators_back.service.impl.ProblemServiceImpl;
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

    @Autowired
    private ProblemServiceImpl problemServiceImpl;

    @Test
    void shouldMapToEntityWithProperNewProblemToValues() {
        //when
        ProblemEntity problemEntity = problemMapper.toProblemEntity(generateNewProblemTo());

        //then
        assertEquals(TITLE, problemEntity.getTitle());
        assertEquals(QUESTION, problemEntity.getQuestion());
    }
    @Test
    void shouldMapToNewProblemTOWithProperProblemEntityValues() {
        //given
        ProblemEntity problemEntity = generateProblemEntity();
        CategoryEntity categoryEntity = generateCategoryEntity();
        problemEntity.setCategoryEntity(categoryEntity);

        //when
        NewProblemTo newProblemTo = problemMapper.toNewProblemTO(problemEntity);

        //then
        assertEquals(TITLE, newProblemTo.getTitle());
        assertEquals(QUESTION, newProblemTo.getQuestion());
        assertEquals(CATEGORY_NAME, newProblemTo.getCategoryName());
    }

    @Test
    void shouldMapToProblemEntityWithProperProblemToValues() {
        //when
        ProblemEntity problemEntity = problemMapper.toProblemEntity(generateProblemTo());

        //then
        assertEquals(Long.valueOf(1L), problemEntity.getId());
        assertEquals(TITLE, problemEntity.getTitle());
        assertEquals(QUESTION, problemEntity.getQuestion());
    }

    @Test
    void shouldMapToProblemToWithProperProblemEntityValues() {
        //given
        ProblemEntity problemEntity = generateProblemEntity();
        CategoryEntity categoryEntity = generateCategoryEntity();
        problemEntity.setCategoryEntity(categoryEntity);

        //when
        ProblemTo problemTo = problemMapper.toProblemTO(problemEntity);

        //then
        assertEquals(Long.valueOf(1L), problemTo.getId());
        assertEquals(TITLE, problemTo.getTitle());
        assertEquals(QUESTION, problemTo.getQuestion());
        assertEquals(categoryEntity, problemServiceImpl.);
    }

    private ProblemTo generateProblemTo(){
        return ProblemTo.builder()
                .id(1L)
                .title(TITLE)
                .question(QUESTION)
                .categoryName(CATEGORY_NAME)
                .build();
    }

    private NewProblemTo generateNewProblemTo(){
        return NewProblemTo.builder()
                .title(TITLE)
                .question(QUESTION)
                .categoryName(CATEGORY_NAME)
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
}