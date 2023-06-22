package com.akademia.educators_back.service.impl;

import com.akademia.educators_back.entity.CategoryEntity;
import com.akademia.educators_back.entity.CommentEntity;
import com.akademia.educators_back.entity.ProblemEntity;
import com.akademia.educators_back.mapper.ProblemMapper;
import com.akademia.educators_back.repository.CategoryRepository;
import com.akademia.educators_back.repository.ProblemRepository;
import com.akademia.educators_back.to.NewProblemTo;
import com.akademia.educators_back.to.ProblemTo;
import com.akademia.educators_back.validator.ProblemValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ProblemServiceImplTest {

    @Autowired
    private ProblemServiceImpl problemService;

    @Mock
    private ProblemRepository problemRepository;

    @Mock
    private ProblemMapper problemMapper;

    @Mock
    private ProblemValidator problemValidator;

    @Mock
    private CategoryRepository categoryRepository;
    NewProblemTo newProblemTo;
    ProblemEntity problemEntity;

    CategoryEntity categoryEntity;

    @BeforeEach
    void setUp() {
        problemService = new ProblemServiceImpl(problemRepository, problemMapper, problemValidator, categoryRepository);
    }

    @Test
    void addProblemWithCorrectData() {
        //given
        newProblemTo = new NewProblemTo();
        problemEntity = new ProblemEntity();
        categoryEntity = new CategoryEntity();

        when(problemMapper.toProblemEntity(newProblemTo)).thenReturn(problemEntity);
        doNothing().when(problemValidator).validNewProblem(newProblemTo);
        when(categoryRepository.getCategoryEntityByCategoryName(newProblemTo.getCategoryName())).thenReturn(categoryEntity);

        //when
        problemService.addProblem(newProblemTo);

        //then
        verify(problemRepository).save(problemEntity);
    }

    @Test
    void deleteProblem() {
    }

    @Test
    void updateProblem() {
    }

    @Test
    void shouldGetProblems() {
        //given
        ProblemEntity firstProblemEntity = new ProblemEntity();
        ProblemEntity secondProblemEntity = new ProblemEntity();
        List<ProblemEntity> problemEntities = new ArrayList<>(
                List.of(firstProblemEntity, secondProblemEntity));

        ProblemTo firstProblemTo = new ProblemTo();
        ProblemTo secondProblemTo = new ProblemTo();
        List<ProblemTo> problemTos = new ArrayList<>(
                List.of(firstProblemTo, secondProblemTo));


        when(problemRepository.findAll()).thenReturn(problemEntities);
        when(problemMapper.toProblemTO(firstProblemEntity)).thenReturn(firstProblemTo);
        when(problemMapper.toProblemTO(secondProblemEntity)).thenReturn(secondProblemTo);

        //when
        List<ProblemTo> actualProblemTo = problemService.getProblems();

        //then
        assertThat(actualProblemTo).containsExactlyElementsOf(problemTos);
    }

    @Test
    void getProblemByIdWithCorrectProvidedId() {
        //given
        ProblemEntity firstProblemEntity = new ProblemEntity(1L, "title1", "question1", List.of(new CommentEntity()), new CategoryEntity());
        ProblemEntity secondProblemEntity = new ProblemEntity(2L, "title2", "question2", List.of(new CommentEntity()), new CategoryEntity());
        List<ProblemEntity> problemEntities = new ArrayList<>(
                List.of(firstProblemEntity, secondProblemEntity));

        ProblemTo firstProblemTo = new ProblemTo(1L, "title1", "question1", List.of(1L), "category1");
        ProblemTo secondProblemTo = new ProblemTo(2L, "title1", "question1", List.of(1L), "category1");
        List<ProblemTo> problemTos = new ArrayList<>(
                List.of(firstProblemTo, secondProblemTo));

        when(problemRepository.findById(1L)).thenReturn(Optional.of(firstProblemEntity));
        when(problemMapper.toProblemTO(firstProblemEntity)).thenReturn(firstProblemTo);

        //when
        ProblemTo problemToExpected = problemService.getProblemById(1L);

        //then
        assertEquals(firstProblemTo, problemToExpected);
    }
}