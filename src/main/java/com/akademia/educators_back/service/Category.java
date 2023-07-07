package com.akademia.educators_back.service;

import com.akademia.educators_back.to.CategoryTo;
import com.akademia.educators_back.to.NewCategoryTo;
import com.akademia.educators_back.to.ProblemTo;

import java.util.List;

/**
 * The Category interface responsible for managing Category objects
 */
public interface Category {

    /**
     * Add new Category object
     * @param newCategoryTo
     */
    void addCategory(NewCategoryTo newCategoryTo);

    /**
     * Get list of exist Category objects
     * @return List of exist CategoryTo
     */
    List<CategoryTo> getCategories();

    /**
     * Get single exist Category object
     * @return exist CategoryTo
     */
    CategoryTo getCategoryById(Long id);
}
