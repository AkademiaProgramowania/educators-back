package com.akademia.educators_back.service.impl;

import com.akademia.educators_back.TestDataGenerator;
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

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ProblemServiceImplTest {

    @Autowired
    TestDataGenerator testDataGenerator;
//    @Autowired
    private ProblemServiceImpl mockProblemService;

    @Autowired
    private ProblemServiceImpl problemService;

    @Autowired
    private ProblemRepository problemRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Mock
    private ProblemRepository mockProblemRepository;

    @Mock
    private ProblemMapper mockProblemMapper;

    @Mock
    private ProblemValidator mockProblemValidator;

    @Mock
    private CategoryRepository mockCategoryRepository;


    @BeforeEach
    void setUp() {
        mockProblemService = new ProblemServiceImpl(mockProblemRepository, mockProblemMapper, mockProblemValidator, mockCategoryRepository);
    }

    @Test
    void verifyMethodInAddProblemWithCorrectData() {

        NewProblemTo newProblemTo = new NewProblemTo();
        ProblemEntity problemEntity = new ProblemEntity();
        CategoryEntity categoryEntity = new CategoryEntity();

        when(mockProblemMapper.toProblemEntity(newProblemTo)).thenReturn(problemEntity);
        doNothing().when(mockProblemValidator).validNewProblem(newProblemTo);
        when(mockCategoryRepository.getCategoryEntityByCategoryName(newProblemTo.getCategoryName())).thenReturn(categoryEntity);

        //when
        mockProblemService.addProblem(newProblemTo);

        //then
        verify(mockProblemRepository).save(problemEntity);
    }

    @Test
    void ShouldAddProblemWithCorrectData() {
        //given
        CategoryEntity categoryEntity1 = testDataGenerator.getCategoryEntity();
        categoryRepository.save(categoryEntity1);
        ProblemEntity problemEntity1 = testDataGenerator.getProblemEntity(categoryEntity1);
        problemRepository.save(problemEntity1);

        NewProblemTo newProblemTo1 = testDataGenerator.getNewProblemTo();

        //when
        problemService.addProblem(newProblemTo1);

        //then
        assertEquals(problemRepository.findAll().get(1).getQuestion(), newProblemTo1.getQuestion());
        assertThat(problemRepository).isNotNull();
        assertThat(problemRepository.findAll()).hasSize(2);
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
        CategoryEntity categoryEntity1 = testDataGenerator.getCategoryEntity();
        categoryRepository.save(categoryEntity1);
        ProblemEntity problemEntity1 = testDataGenerator.getProblemEntity(categoryEntity1);
        problemRepository.save(problemEntity1);
        List<ProblemEntity> problemEntities = new ArrayList<>(
                List.of(problemEntity1));

        ProblemTo problemTo1 = testDataGenerator.getProblemTo();

        List<ProblemTo> problemTos = new ArrayList<>(
                List.of(problemTo1));


        when(mockProblemRepository.findAll()).thenReturn(problemEntities);
        when(mockProblemMapper.toProblemTO(problemEntity1)).thenReturn(problemTo1);

        //when
        List<ProblemTo> actualProblemTo = mockProblemService.getProblems();

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

//        when(problemRepository.findById(1L)).thenReturn(Optional.of(firstProblemEntity));
//        when(problemMapper.toProblemTO(firstProblemEntity)).thenReturn(firstProblemTo);

        //when
//        ProblemTo problemToExpected = problemService.getProblemById(1L);

        //then
//        assertEquals(firstProblemTo, problemToExpected);
    }
}