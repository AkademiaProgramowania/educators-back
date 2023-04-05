package com.akademia.educators_back.repository;

import com.akademia.educators_back.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<CommentEntity, Long> {

    boolean commentExists(String question0);
}
