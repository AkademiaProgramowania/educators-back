package com.akademia.educators_back.service.impl;

import com.akademia.educators_back.TestDataGenerator;
import com.akademia.educators_back.entity.CategoryEntity;
import com.akademia.educators_back.entity.ProblemEntity;
import com.akademia.educators_back.repository.CategoryRepository;
import com.akademia.educators_back.repository.ProblemRepository;
import com.akademia.educators_back.to.NewProblemTo;
import com.akademia.educators_back.to.ProblemTo;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ProblemServiceImplTestRealRepo {

    @Autowired
    TestDataGenerator testDataGenerator;


    @Autowired
    private ProblemServiceImpl problemService;

    @Autowired
    private ProblemRepository problemRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    CategoryEntity categoryEntity;
    ProblemEntity problemEntity;

    NewProblemTo newProblemTo;
    ProblemTo problemTo;

    @BeforeEach
    void setUp() {
        categoryEntity = testDataGenerator.getCategoryEntity();
        categoryRepository.save(categoryEntity);
        problemEntity = testDataGenerator.getProblemEntity(categoryEntity);
        problemRepository.save(problemEntity);
        newProblemTo = testDataGenerator.getNewProblemTo();
        problemTo = testDataGenerator.getProblemTo();
    }

    @AfterEach
    void tearDown() {
        categoryRepository.deleteAll();
        problemRepository.deleteAll();
    }

    @Test
    void addProblem() {
        problemService.addProblem(newProblemTo);

        //then
        assertEquals(problemRepository.findAll().get(1).getQuestion(), newProblemTo.getQuestion());
        assertThat(problemRepository).isNotNull();
        assertThat(problemRepository.findAll()).hasSize(2);
    }

    @Test
    void deleteProblem() {
        //when
        problemService.deleteProblem(problemTo);

        //then
        assertThat(problemRepository.findAll()).hasSize(0);
    }

    @Test
    void updateProblem() {
        ProblemTo problemToForUpdate = testDataGenerator.getProblemToForUpdate();

        //when
        problemService.updateProblem(problemToForUpdate);

        //then
        assertEquals(problemRepository.findAll().get(0).getQuestion(), problemToForUpdate.getQuestion());
    }

    @Test
    void getProblems() {
    }

    @Test
    void getProblemById() {
    }
}