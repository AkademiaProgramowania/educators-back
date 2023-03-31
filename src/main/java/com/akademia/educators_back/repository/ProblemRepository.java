package com.akademia.educators_back.repository;

import com.akademia.educators_back.entity.ProblemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProblemRepository extends JpaRepository<ProblemEntity, Long> {

    //TODO wg konwencji daszki _ dajemy raczej do stałych więc lepszy camelCase.
    // Samą nazwę bym trochę uprościł bo nie rozumiem czym
    // jest ten boolean np: ifCategoryNameExists podobnie poniżej
    // np: ifQuestionExists

    boolean existsByCategoryEntity_CategoryName(String categoryName);
    boolean existsByQuestion(String question);

    @Query ("from ProblemEntity p where p.categoryEntity.categoryName = :categoryName")
    boolean ifCategoryNameExist(@Param("categoryName") String categoryName);

    @Query("from ProblemEntity p where p.question = :question" )
    boolean ifQuestionExist(@Param("question") String question);
}
