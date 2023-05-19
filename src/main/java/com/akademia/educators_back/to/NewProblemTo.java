package com.akademia.educators_back.to;

import com.akademia.educators_back.entity.CategoryEntity;
import jakarta.persistence.Column;
import lombok.*;


import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.List;

@Getter
@Setter
public class NewProblemTo {


    @Size(min = 3, max = 100)
    private String title;
    @UniqueElements
    @Size(min = 10, max = 1000, message = "Provided title has incorrect length")
    private String question;
    private List<Long> commentsToId;
    private String categoryName;
}
