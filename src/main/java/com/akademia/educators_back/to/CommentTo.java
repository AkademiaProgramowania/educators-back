package com.akademia.educators_back.to;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentTo {

    private Long id;
    private String answer;
    private Long userId;
    private Long problemToId;
}
