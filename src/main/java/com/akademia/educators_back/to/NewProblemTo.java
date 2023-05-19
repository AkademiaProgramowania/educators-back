package com.akademia.educators_back.to;

import com.akademia.educators_back.entity.CategoryEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Object representing new problem
 */
@Getter
@Setter
public class NewProblemTo {

    private String title;
    private String question;
    private List<Long> commentsToId;
    private String categoryName;
}
