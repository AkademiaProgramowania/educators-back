package com.akademia.educators_back.service.impl;

import com.akademia.educators_back.entity.CategoryEntity;
import com.akademia.educators_back.entity.ProblemEntity;
import com.akademia.educators_back.mapper.ProblemMapper;
import com.akademia.educators_back.repository.CategoryRepository;
import com.akademia.educators_back.repository.ProblemRepository;
import com.akademia.educators_back.to.NewProblemTo;
import com.akademia.educators_back.validator.ProblemValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
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
    void getProblems() {
    }

    @Test
    void getProblemById() {
    }
}