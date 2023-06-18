package com.akademia.educators_back.to;

import jakarta.validation.constraints.Size;
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

    @Size(min = 3, max = 100)
    private String title;

    @Size(min = 10, max = 1000)
    private String question;

    private List<Long> commentsToId;

    private String categoryName;
}
