package com.akademia.educators_back.to;

import com.akademia.educators_back.entity.CategoryEntity;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewProblemTo {

    @Size(min = 3, max = 100)
    private String title;

    @Size(min = 10, max = 1000)
    private String question;

    private List<Long> commentsToId;

    private String categoryName;
}
