package com.akademia.educators_back.to;

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

    private String categoryName;

    private List<Long> problemsToId;
}
