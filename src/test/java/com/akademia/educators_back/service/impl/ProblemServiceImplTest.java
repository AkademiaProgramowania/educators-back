package com.akademia.educators_back.service.impl;

import com.akademia.educators_back.TestDataGenerator;
//import com.akademia.educators_back.config.DataLoader;
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
//    @Autowired
//    private ProblemMapper problemMapper;

//    @Autowired
//    private ProblemValidator problemValidator;



//    @Autowired
//    ProblemRepository problemRepo;
//    @Autowired
//    CategoryRepository categoryRepo;
//    NewProblemTo newProblemTo;
//    ProblemEntity problemEntity;
    CategoryEntity categoryEntity;

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
    void testForJul() {
        //given
//        newProblemTo = new NewProblemTo();
//        problemEntity = new ProblemEntity();
//        categoryEntity = new CategoryEntity();

//        ProblemServiceImpl problemServiceNotMocked = new ProblemServiceImpl(problemRepo, problemMapper, problemValidator, categoryRepo);

        CategoryEntity categoryEntity1 = testDataGenerator.getCategoryEntity();
        categoryRepository.save(categoryEntity1);
        ProblemEntity problemEntity1 = testDataGenerator.getProblemEntity(categoryEntity1);
        problemRepository.save(problemEntity1);

        NewProblemTo newProblemTo1 = testDataGenerator.getNewProblemTo();


//        when(problemMapper.toProblemEntity(newProblemTo1)).thenReturn(problemEntity1);
//        doNothing().when(problemValidator).validNewProblem(newProblemTo1);
//        when(categoryRepository.getCategoryEntityByCategoryName(newProblemTo1.getCategoryName())).thenReturn(categoryEntity);
//        when(problemRepository.save(problemEntity1)).thenReturn(problemEntity1);

        //when
        problemService.addProblem(newProblemTo1);
        List<ProblemEntity> problemEntities = problemRepository.findAll();
        //then
//        verify(problemRepository).save(problemEntity1);
        assertEquals(problemRepository.findAll().get(1).getQuestion(), newProblemTo1.getQuestion());
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


//        when(problemRepository.findAll()).thenReturn(problemEntities);
//        when(problemMapper.toProblemTO(firstProblemEntity)).thenReturn(firstProblemTo);
//        when(problemMapper.toProblemTO(secondProblemEntity)).thenReturn(secondProblemTo);

        //when
//        List<ProblemTo> actualProblemTo = problemService.getProblems();

        //then
//        assertThat(actualProblemTo).containsExactlyElementsOf(problemTos);
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