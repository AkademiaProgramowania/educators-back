package com.akademia.educators_back.to;

import com.akademia.educators_back.entity.CategoryEntity;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.UniqueElements;

import java.util.List;

@Getter
@Setter
public class ProblemTo {

    private Long id;

    @Size(min = 3, max = 100)
    private String title;

    @Size(min = 10, max = 1000)
    private String question;

    private List<Long> commentsToId;

    private CategoryEntity categoryEntity;
}
