package com.akademia.educators_back.to;

import com.akademia.educators_back.entity.CategoryEntity;
import lombok.*;

import java.util.List;

/**
 * Transfer object representing new Problem object for saving in database.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NewProblemTo {

    private String title;
    private String question;
    private List<Long> commentsToId;
    private String categoryName;
}
