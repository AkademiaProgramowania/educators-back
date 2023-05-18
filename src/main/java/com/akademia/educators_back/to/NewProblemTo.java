package com.akademia.educators_back.to;

import com.akademia.educators_back.entity.CategoryEntity;
import lombok.*;


import jakarta.validation.constraints.Size;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewProblemTo {

    @Size(min = 3, max = 100)
    private String title;
    private String question;
    private List<Long> commentsToId;
    private String categoryName;
}
