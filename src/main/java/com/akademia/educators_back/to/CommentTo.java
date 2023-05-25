package com.akademia.educators_back.to;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class CommentTo {
    @NotNull
    private Long id;
    @NotEmpty
    @Size(min=2, message = "answer must be min 2 characters")
    private String answer;
    private Long userId;
    private Long problemToId;
}
