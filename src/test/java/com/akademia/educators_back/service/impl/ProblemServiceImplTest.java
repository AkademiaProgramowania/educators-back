package com.akademia.educators_back.service.impl;

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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ProblemServiceImplTest {

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

    @BeforeEach
    void setUp() {
        problemService = new ProblemServiceImpl(problemRepository, problemMapper, problemValidator, categoryRepository);

    }

    @Test
    void addProblem() {
        newProblemTo = new NewProblemTo();

        when(problemMapper.toProblemEntity(newProblemTo)).thenReturn()
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