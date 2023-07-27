package com.akademia.educators_back.service.impl;

import com.akademia.educators_back.TestDataGenerator;
import com.akademia.educators_back.entity.CategoryEntity;
import com.akademia.educators_back.entity.ProblemEntity;
import com.akademia.educators_back.mapper.CategoryMapper;
import com.akademia.educators_back.repository.CategoryRepository;
import com.akademia.educators_back.to.CategoryTo;
import com.akademia.educators_back.to.NewCategoryTo;
import com.akademia.educators_back.validator.CategoryValidator;
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
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CategoryServiceImplTestVerify {

    @Autowired
    TestDataGenerator testDataGenerator;
    private CategoryServiceImpl mockCategoryService;

    @Mock
    private CategoryMapper mockCategoryMapper;

    @Mock
    private CategoryValidator mockCategoryValidator;

    @Mock
    private CategoryRepository mockCategoryRepository;
    NewCategoryTo newCategoryToForMock;
    CategoryTo categoryToForMock;
    ProblemEntity problemEntityForMock;
    CategoryEntity categoryEntityForMock;

    @BeforeEach
    void setUp() {
        mockCategoryService = new CategoryServiceImpl(mockCategoryRepository, mockCategoryMapper, mockCategoryValidator);
        categoryToForMock = testDataGenerator.getCategoryTo();
        newCategoryToForMock = testDataGenerator.getNewCategoryTo();
        categoryEntityForMock = testDataGenerator.getCategoryEntity();
        problemEntityForMock = testDataGenerator.getProblemEntity(categoryEntityForMock);
    }

    @Test
    void verifyMethodToAddCategoryWithCorrectData() {
        //given
        when(mockCategoryMapper.toCategoryEntity(newCategoryToForMock)).thenReturn(categoryEntityForMock);
        doNothing().when(mockCategoryValidator).categoryExistCheck(newCategoryToForMock);

        //when
        mockCategoryService.addCategory(newCategoryToForMock);

        //then
        verify(mockCategoryRepository).save(categoryEntityForMock);
    }

    @Test
    void verifyMethodToDeleteCategoryWithCorrectData() {
        //given
        when(mockCategoryMapper.toCategoryEntity(categoryToForMock)).thenReturn(categoryEntityForMock);
        doNothing().when(mockCategoryValidator).categoryExistCheck(categoryToForMock);

        //when
        mockCategoryService.deleteCategory(categoryToForMock);

        //then
        verify(mockCategoryRepository).delete(categoryEntityForMock);
    }

    @Test
    void verifyMethodToUpdateCategoryWithCorrectData() {
        //given
        doNothing().when(mockCategoryValidator).categoryExistCheck(categoryToForMock);
        when(mockCategoryRepository.findById(categoryToForMock.getId())).thenReturn(Optional.of(categoryEntityForMock));

        //when
        mockCategoryService.updateCategory(categoryToForMock);

        //then
        verify(mockCategoryRepository).save(categoryEntityForMock);
    }

    @Test
    void verifyMethodToGetCategoryWithCorrectData() {
        //given
        List<CategoryEntity> categoryEntities = new ArrayList<>(
                List.of(categoryEntityForMock));

        List<CategoryTo> categoryTos = new ArrayList<>(
                List.of(categoryToForMock));

        when(mockCategoryRepository.findAll()).thenReturn(categoryEntities);
        when(mockCategoryMapper.toCategoryTo(categoryEntityForMock)).thenReturn(categoryToForMock);

        //when
        List<CategoryTo> actualCategoryTo = mockCategoryService.getCategories();

        //then
        assertThat(actualCategoryTo).containsExactlyElementsOf(categoryTos);
        verify(mockCategoryRepository).findAll();
    }

    @Test
    void verifyMethodToGetOneCategoryWithCorrectData() {
        //given
        when(mockCategoryRepository.findById(1L)).thenReturn(Optional.of(categoryEntityForMock));
        when(mockCategoryMapper.toCategoryTo(categoryEntityForMock)).thenReturn(categoryToForMock);

        //when
        CategoryTo categoryToExpected = mockCategoryService.getCategoryById(1L);

        //then
        assertEquals(categoryToForMock, categoryToExpected);
    }
}