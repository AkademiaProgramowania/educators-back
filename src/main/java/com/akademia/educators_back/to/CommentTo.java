package com.akademia.educators_back.to;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentTo {

    private Long id;
    private String answer;
    private UserTo userTo;
    private ProblemTo problemTo;
}
