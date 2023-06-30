package com.akademia.educators_back.service.impl;

import com.akademia.educators_back.TestDataGenerator;
import com.akademia.educators_back.entity.CategoryEntity;
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
    void shouldAddProblemWithCorrectData() {
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
    void shouldDeleteProblemWithCorrectData() {
        //given
        CategoryEntity categoryEntity1 = testDataGenerator.getCategoryEntity();
        categoryRepository.save(categoryEntity1);
        ProblemEntity problemEntity1 = testDataGenerator.getProblemEntity(categoryEntity1);
        problemRepository.save(problemEntity1);

        ProblemTo problemTo1 = testDataGenerator.getProblemTo();

        //when
        problemService.deleteProblem(problemTo1);

        //then
        assertThat(problemRepository.findAll()).hasSize(0);
    }

    @Test
    void verifyMethodInDeleteProblemWithCorrectData() {
        ProblemTo problemTo = new ProblemTo();
        ProblemEntity problemEntity = new ProblemEntity();

        when(mockProblemMapper.toProblemEntity(problemTo)).thenReturn(problemEntity);
        doNothing().when(mockProblemValidator).validExistProblem(problemTo);

        //when
        mockProblemService.deleteProblem(problemTo);

        //then
        verify(mockProblemRepository).delete(problemEntity);
    }

    @Test
    void shouldUpdateProblemWithCorrectData() {
        //given
        CategoryEntity categoryEntity2 = testDataGenerator.getCategoryEntity();
        categoryRepository.save(categoryEntity2);
        ProblemEntity problemEntity2 = testDataGenerator.getProblemEntity(categoryEntity2);
        problemRepository.save(problemEntity2);

        ProblemTo problemTo2 = testDataGenerator.getProblemToForUpdate();

        //when
        problemService.updateProblem(problemTo2);

        //then
        assertEquals(problemRepository.findAll().get(0).getQuestion(), problemTo2.getQuestion());
    }

    @Test
    void verifyMethodInUpdateProblemWithCorrectData() {
        //given
        ProblemTo problemTo = new ProblemTo();
        ProblemEntity problemEntity = new ProblemEntity();

        doNothing().when(mockProblemValidator).validExistProblemForUpdate(problemTo);
        when(mockProblemRepository.findById(problemTo.getId())).thenReturn(Optional.of(problemEntity));

        //when
        mockProblemService.updateProblem(problemTo);

        //then
        verify(mockProblemRepository).save(problemEntity);

    }
    @Test
    void shouldGetProblems() {
        //given
        CategoryEntity categoryEntity1 = testDataGenerator.getCategoryEntity();
        ProblemEntity problemEntity1 = testDataGenerator.getProblemEntity(categoryEntity1);
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
        CategoryEntity categoryEntity1 = testDataGenerator.getCategoryEntity();
        ProblemEntity problemEntity1 = testDataGenerator.getProblemEntity(categoryEntity1);
        List<ProblemEntity> problemEntities = new ArrayList<>(
                List.of(problemEntity1));
        ProblemTo problemTo1 = testDataGenerator.getProblemTo();

        when(mockProblemRepository.findById(1L)).thenReturn(Optional.of(problemEntity1));
        when(mockProblemMapper.toProblemTO(problemEntity1)).thenReturn(problemTo1);

        //when
        ProblemTo problemToExpected = mockProblemService.getProblemById(1L);

        //then
        assertEquals(problemTo1, problemToExpected);
    }
}