package com.akademia.educators_back;

import com.akademia.educators_back.entity.CategoryEntity;
import com.akademia.educators_back.entity.ProblemEntity;
import com.akademia.educators_back.to.NewProblemTo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@AllArgsConstructor
public class TestDataGenerator {

    public CategoryEntity getCategoryEntity(){
        return CategoryEntity.builder()
                .categoryName("Category")
                .problems(new ArrayList<>())
                .build();
    }

    public ProblemEntity getProblemEntity(CategoryEntity categoryEntity){
        return ProblemEntity.builder()
                .title("title")
                .question("question")
                .comments(new ArrayList<>())
                .categoryEntity(categoryEntity)
                .build();
    }

    public NewProblemTo getNewProblemTo(){
        return NewProblemTo.builder()
                .title("titleFromTo")
                .question("questionFromTo")
                .commentsToId(new ArrayList<>())
                .categoryName("Category")
                .build();
    }

}
