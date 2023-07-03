package com.akademia.educators_back.service.impl;

import com.akademia.educators_back.entity.CategoryEntity;
import com.akademia.educators_back.entity.ProblemEntity;
import com.akademia.educators_back.mapper.CategoryMapper;
import com.akademia.educators_back.repository.CategoryRepository;
import com.akademia.educators_back.service.Category;
import com.akademia.educators_back.to.CategoryTo;
import com.akademia.educators_back.to.NewCategoryTo;
import com.akademia.educators_back.to.ProblemTo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service for handling category
 */
@Service
@AllArgsConstructor
public class CategoryServiceImpl implements Category {

    private CategoryRepository categoryRepository;

    private CategoryMapper categoryMapper;

    /**
     * Add new category
     * @param newCategoryTo New category TO is an object without ID representing a new category
     */
    @Override
    public void addCategory(NewCategoryTo newCategoryTo) {
        CategoryEntity categoryEntity = categoryMapper.toCategoryEntity(newCategoryTo);
        categoryRepository.save(categoryEntity);
    }

    /**
     * Get list of exist categories
     */
    @Override
    public List<CategoryTo> getCategories() {
        List<CategoryTo> categoriesTo = new ArrayList<>();
        List<CategoryEntity> categoriesEntity = categoryRepository.findAll();
        for (CategoryEntity category : categoriesEntity){
            categoriesTo.add(categoryMapper.toCategoryTO(category));
        }
        return categoriesTo;
    }
}
