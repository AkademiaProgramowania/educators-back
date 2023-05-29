package com.akademia.educators_back.to;

import com.akademia.educators_back.entity.CategoryEntity;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.List;

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
