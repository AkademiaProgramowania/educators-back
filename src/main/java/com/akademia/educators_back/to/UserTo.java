package com.akademia.educators_back.to;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserTo {

    private Long id;
    private String name;
    private String password;
    private List<Long> commentsToId;
}
