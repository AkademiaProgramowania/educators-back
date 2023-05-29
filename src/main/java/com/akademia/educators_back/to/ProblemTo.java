package com.akademia.educators_back.to;

import com.akademia.educators_back.entity.CategoryEntity;
import lombok.*;
import org.aspectj.lang.annotation.Before;

import java.util.List;

/**
 * Object representing exist problem
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProblemTo {

    private Long id;
    private String title;
    private String question;
    private List<Long> commentsToId;
    private CategoryEntity categoryEntity;
}
