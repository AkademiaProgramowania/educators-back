package com.akademia.educators_back.repository;

import com.akademia.educators_back.entity.ProblemEntity;
import com.akademia.educators_back.to.ProblemTo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProblemRepository extends JpaRepository<ProblemEntity, Long> {

    boolean existsByCategoryEntity_CategoryName(String categoryName);
    boolean existsByQuestion(String question);

}
