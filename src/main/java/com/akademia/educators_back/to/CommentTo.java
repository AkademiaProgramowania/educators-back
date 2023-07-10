package com.akademia.educators_back.to;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CommentTo {

    private Long id;
    private String answer;
    private Long userId;
    private Long problemToId;
}
