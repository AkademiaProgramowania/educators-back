package com.akademia.educators_back;

import com.akademia.educators_back.entity.CategoryEntity;
import com.akademia.educators_back.entity.ProblemEntity;
import com.akademia.educators_back.to.NewProblemTo;
import com.akademia.educators_back.to.ProblemTo;
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
                .question("random question")
                .comments(new ArrayList<>())
                .categoryEntity(categoryEntity)
                .build();
    }

    public NewProblemTo getNewProblemTo(){
        return NewProblemTo.builder()
                .title("titleFromNewTo")
                .question("questionFromNewTo")
                .commentsToId(new ArrayList<>())
                .categoryName("Category")
                .build();
    }

    public ProblemTo getProblemTo(){
        return ProblemTo.builder()
                .id(1L)
                .title("title")
                .question("random question")
                .commentsToId(new ArrayList<>())
                .categoryName("Category")
                .build();
    }

    public ProblemTo getProblemToForUpdate(){
        return ProblemTo.builder()
                .id(1L)
                .title("new title")
                .question("new random question")
                .commentsToId(new ArrayList<>())
                .categoryName("Category")
                .build();
    }


}
