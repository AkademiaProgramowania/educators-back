package com.akademia.educators_back.mapper;

import com.akademia.educators_back.entity.CategoryEntity;
import com.akademia.educators_back.to.NewCategoryTo;
import org.springframework.stereotype.Component;

/**
 * Class for mapping category transfer object and problem entity
 */
@Component
public class CategoryMapper {

    /**
     * Map category object into new category transfer object
     * @param newCategoryTo New category TO is an object without ID representing a new category
     * @return category entity
     */
    public CategoryEntity toCategoryEntity(NewCategoryTo newCategoryTo){
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryName(newCategoryTo.getCategoryName());
        return categoryEntity;
    }

    /**
     * Map new category TO object into category entity
     * @param categoryEntity Category entity representing a category
     * @return new category TO
     */
    public NewCategoryTo toNewCategoryTO(CategoryEntity categoryEntity){
        NewCategoryTo newCategoryTo = new NewCategoryTo();
        newCategoryTo.setCategoryName(categoryEntity.getCategoryName());
        return newCategoryTo;
    }
}
