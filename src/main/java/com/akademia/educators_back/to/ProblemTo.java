package com.akademia.educators_back.to;

import com.akademia.educators_back.entity.CategoryEntity;
import lombok.*;
import org.aspectj.lang.annotation.Before;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProblemTo {

    private Long id;

    @Size(min = 3, max = 100)
    private String title;

    @Size(min = 10, max = 1000)
    private String question;
    private List<Long> commentsToId;
    private CategoryEntity categoryEntity;
}
