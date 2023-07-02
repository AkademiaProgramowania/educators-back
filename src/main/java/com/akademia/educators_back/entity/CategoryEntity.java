package com.akademia.educators_back.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "categories", uniqueConstraints = @UniqueConstraint(columnNames = {"categoryName"}))
public class CategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String categoryName;

    @OneToMany(mappedBy = "categoryEntity")
    private List<ProblemEntity> problems;

}
