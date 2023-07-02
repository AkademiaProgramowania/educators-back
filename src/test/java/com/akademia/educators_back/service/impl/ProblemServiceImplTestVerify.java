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
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class ProblemServiceImplTestVerify {

    @Autowired
    TestDataGenerator testDataGenerator;
    private ProblemServiceImpl mockProblemService;

    @Mock
    private ProblemRepository mockProblemRepository;

    @Mock
    private ProblemMapper mockProblemMapper;

    @Mock
    private ProblemValidator mockProblemValidator;

    @Mock
    private CategoryRepository mockCategoryRepository;
    NewProblemTo newProblemToForMock;
    ProblemTo problemToForMock;
    ProblemEntity problemEntityForMock;
    CategoryEntity categoryEntityForMock;

    @BeforeEach
    void setUp() {
        mockProblemService = new ProblemServiceImpl(mockProblemRepository, mockProblemMapper, mockProblemValidator, mockCategoryRepository);
        newProblemToForMock = testDataGenerator.getNewProblemTo();
        categoryEntityForMock = testDataGenerator.getCategoryEntity();
        problemEntityForMock = testDataGenerator.getProblemEntity(categoryEntityForMock);
        problemToForMock = testDataGenerator.getProblemTo();
    }

    @Test
    void verifyMethodToAddProblemWithCorrectData() {
        //given
        when(mockProblemMapper.toProblemEntity(newProblemToForMock)).thenReturn(problemEntityForMock);
        doNothing().when(mockProblemValidator).validNewProblem(newProblemToForMock);
        when(mockCategoryRepository.getCategoryEntityByCategoryName(newProblemToForMock.getCategoryName())).thenReturn(categoryEntityForMock);

        //when
        mockProblemService.addProblem(newProblemToForMock);

        //then
        verify(mockProblemRepository).save(problemEntityForMock);
    }

    @Test
    void verifyMethodToDeleteProblemWithCorrectData() {
        //given
        when(mockProblemMapper.toProblemEntity(problemToForMock)).thenReturn(problemEntityForMock);
        doNothing().when(mockProblemValidator).validExistProblem(problemToForMock);

        //when
        mockProblemService.deleteProblem(problemToForMock);

        //then
        verify(mockProblemRepository).delete(problemEntityForMock);
    }

    @Test
    void verifyMethodToUpdateProblemWithCorrectData() {
        //given
        doNothing().when(mockProblemValidator).validExistProblem(problemToForMock);
        when(mockProblemRepository.findById(problemToForMock.getId())).thenReturn(Optional.of(problemEntityForMock));

        //when
        mockProblemService.updateProblem(problemToForMock);

        //then
        verify(mockProblemRepository).save(problemEntityForMock);

    }

    @Test
    void verifyMethodToGetProblemWithCorrectData() {
        //given
        List<ProblemEntity> problemEntities = new ArrayList<>(
                List.of(problemEntityForMock));

        List<ProblemTo> problemTos = new ArrayList<>(
                List.of(problemToForMock));

        when(mockProblemRepository.findAll()).thenReturn(problemEntities);
        when(mockProblemMapper.toProblemTO(problemEntityForMock)).thenReturn(problemToForMock);

        //when
        List<ProblemTo> actualProblemTo = mockProblemService.getProblems();

        //then
        assertThat(actualProblemTo).containsExactlyElementsOf(problemTos);
        verify(mockProblemRepository).findAll();
    }

    @Test
    void verifyMethodToGetOneWithCorrectData() {
        //given
        List<ProblemEntity> problemEntities = new ArrayList<>(
                List.of(problemEntityForMock));

        when(mockProblemRepository.findById(1L)).thenReturn(Optional.of(problemEntityForMock));
        when(mockProblemMapper.toProblemTO(problemEntityForMock)).thenReturn(problemToForMock);

        //when
        ProblemTo problemToExpected = mockProblemService.getProblemById(1L);

        //then
        assertEquals(problemToForMock, problemToExpected);
    }
}