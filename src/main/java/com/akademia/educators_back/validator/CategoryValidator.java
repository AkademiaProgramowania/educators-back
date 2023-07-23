package com.akademia.educators_back.validator;

import com.akademia.educators_back.exception.CategoryAlreadyExistException;
import com.akademia.educators_back.exception.ProblemAlreadyExistException;
import com.akademia.educators_back.repository.CategoryRepository;
import com.akademia.educators_back.to.CategoryTo;
import com.akademia.educators_back.to.NewCategoryTo;
import com.akademia.educators_back.to.ProblemTo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CategoryValidator {

    private CategoryRepository categoryRepository;

    /**
     * Check if the category already exist
     * @param categoryTo category TO is an object with ID representing a category
     */
    public void categoryExistCheck(CategoryTo categoryTo) {
        if (categoryRepository.existsByCategoryName(categoryTo.getCategoryName())) {
            throw new CategoryAlreadyExistException(categoryTo.getCategoryName());
        }
    }

    /**
     * Check if the category already exist
     * @param newCategoryTo category TO is an object without id representing a category
     */
    public void categoryExistCheck(NewCategoryTo newCategoryTo) {
        if (categoryRepository.existsByCategoryName(newCategoryTo.getCategoryName())) {
            throw new CategoryAlreadyExistException(newCategoryTo.getCategoryName());
        }
    }
}
