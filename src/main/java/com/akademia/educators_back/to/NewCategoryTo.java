package com.akademia.educators_back.to;

import lombok.*;

import java.util.List;

/**
 * Transfer object representing new Category object for saving in database.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewCategoryTo {
    private String categoryName;

    private List<Long> problemsToId;
}
