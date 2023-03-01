package com.akademia.educators_back.to;

import com.akademia.educators_back.entity.CategoryEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProblemTo {

    private Long id;
    private String title;
    private String question;
    private List<Long> commentsToId;
    private CategoryEntity categoryEntity;
}
