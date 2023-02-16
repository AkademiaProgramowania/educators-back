package com.akademia.educators_back.entity;

import com.akademia.educators_back.enums.QuestionCategory;
import jakarta.persistence.*;
import jdk.jfr.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "questions")
public class QuestionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    private QuestionCategory questionCategory;

    @OneToMany(mappedBy = "question")
    private List<AnswerEntity> answers;
}
