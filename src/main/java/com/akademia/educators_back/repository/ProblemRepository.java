package com.akademia.educators_back.repository;

import com.akademia.educators_back.entity.ProblemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Repository interface for accessing problem entities.
 */
public interface ProblemRepository extends JpaRepository<ProblemEntity, Long> {

    boolean existsByCategoryEntity_CategoryName(String categoryName);
    boolean existsByQuestion(String question);

    @Query ("from ProblemEntity p where p.categoryEntity.categoryName = :categoryName")
    boolean ifCategoryNameExist(@Param("categoryName") String categoryName);

    @Query("from ProblemEntity p where p.question = :question" )
    boolean ifQuestionExist(@Param("question") String question);
}
