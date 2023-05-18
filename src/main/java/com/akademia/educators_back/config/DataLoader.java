package com.akademia.educators_back.config;

import com.akademia.educators_back.entity.CategoryEntity;
import com.akademia.educators_back.entity.ProblemEntity;
import com.akademia.educators_back.repository.CategoryRepository;
import com.akademia.educators_back.repository.ProblemRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Backend data for tests.
 */
@Component
@AllArgsConstructor
public class DataLoader implements ApplicationListener<ContextRefreshedEvent> {
    private ProblemRepository problemRepository;

    private CategoryRepository categoryRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setCategoryName("Category");
        categoryRepository.save(categoryEntity);

        ProblemEntity problemEntity = new ProblemEntity();
        problemEntity.setTitle("Primitive types");
        problemEntity.setQuestion("How many primitive types in java do you know?");
        problemEntity.setCategoryEntity(categoryEntity);
        problemRepository.save(problemEntity);
    }
}
