package com.akademia.educators_back.mapper;

import com.akademia.educators_back.entity.CategoryEntity;
import com.akademia.educators_back.to.CategoryTo;
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

    /**
     * Map category transfer object into category entity
     * @param categoryTo Category TO is an object with ID representing a category
     * @return category entity
     */
    public CategoryEntity toCategoryEntity(CategoryTo categoryTo){
        CategoryEntity categoryEntity = new CategoryEntity();
        if(categoryTo != null){
            categoryEntity.setId(categoryTo.getId());
        }
        categoryEntity.setCategoryName(categoryTo.getCategoryName());
        return categoryEntity;
    }

    /**
     * Map category entity object into category transfer object
     * @param categoryEntity Category entity representing a category
     * @return category TO
     */
    public CategoryTo toCategoryTO(CategoryEntity categoryEntity){
        CategoryTo categoryTo = new CategoryTo();
        if(categoryEntity != null){
            categoryTo.setId(categoryEntity.getId());
        }
        categoryTo.setCategoryName(categoryEntity.getCategoryName());
        return categoryTo;
    }
}
