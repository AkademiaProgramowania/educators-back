package com.akademia.educators_back.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

/**
 * Entity of Problem object.
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "problems")
public class ProblemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //TODO left commented code to faster check differences
    // between @annotation on Entity and To
    // @Size(min = 3, max = 100)
    private String title;

    //TODO left commented code to faster check differences
    // between @annotation on Entity and To
    // @Size(min = 10, max = 1000)
    @Column(unique = true)
    private String question;

    @OneToMany(mappedBy = "problemEntity")
    private List<CommentEntity> comments;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity categoryEntity;
}
