package com.akademia.educators_back.to;

import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

/**
 * Transfer object representing exist Category object for saving in database.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CategoryTo {

    private Long id;

    @Size(min = 5, max = 50)
    private String categoryName;

    private List<Long> problemsToId;
}
