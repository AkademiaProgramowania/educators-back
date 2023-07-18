package com.akademia.educators_back.service.impl;

import com.akademia.educators_back.entity.CategoryEntity;
import com.akademia.educators_back.exception.CategoryDoesNotExistException;
import com.akademia.educators_back.mapper.CategoryMapper;
import com.akademia.educators_back.repository.CategoryRepository;
import com.akademia.educators_back.service.Category;
import com.akademia.educators_back.to.CategoryTo;
import com.akademia.educators_back.to.NewCategoryTo;
import com.akademia.educators_back.validator.CategoryValidator;
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
    private CategoryValidator categoryValidator;

    /**
     * Add new category
     * @param newCategoryTo New category TO is an object without ID representing a new category
     */
    @Override
    public void addCategory(NewCategoryTo newCategoryTo) {
        categoryValidator.categoryExistCheck(newCategoryTo);
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
            categoriesTo.add(categoryMapper.toCategoryTo(category));
        }
        return categoriesTo;
    }

    /**
     * Get single category with provided param.
     * Throws: CategoryDoesNotExistException when category with given id does not exist
     * @param id ID is unique number which represent every one category.
     */
    @Override
    public CategoryTo getCategoryById(Long id) {
        CategoryEntity categoryEntity = categoryRepository.findById(id).orElseThrow(()->new CategoryDoesNotExistException(id));
        return categoryMapper.toCategoryTo(categoryEntity);
    }

    /**
     * Update exist category
     * Throws: CategoryDoesNotExistException when category with given id does not exist
     * @param categoryTo category TO is an object with ID representing a category
     */
    @Override
    public void updateCategory(CategoryTo categoryTo) {
        categoryValidator.categoryExistCheck(categoryTo);
        CategoryEntity categoryEntity;
        categoryEntity = categoryRepository.findById(categoryTo.getId()).orElseThrow(()->new CategoryDoesNotExistException(categoryTo.getId()));
        categoryEntity.setCategoryName(categoryTo.getCategoryName());
        categoryRepository.save(categoryEntity);
    }

    /**
     * Delete exist category
     * @param categoryTo category TO is an object with ID representing a category
     */
    @Override
    public void deleteCategory(CategoryTo categoryTo) {
        categoryValidator.categoryExistCheck(categoryTo);
        CategoryEntity categoryEntity = categoryMapper.toCategoryEntity(categoryTo);
        categoryRepository.delete(categoryEntity);
    }

}
