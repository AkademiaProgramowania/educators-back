package com.akademia.educators_back.repository;

import com.akademia.educators_back.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    boolean existsByAnswer(String answer);

    @Query("from CommentEntity p where p.answer =:answer")
    boolean ifAnswerExists(@Param("answer") String answer);
}
