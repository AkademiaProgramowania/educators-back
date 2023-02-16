package com.akademia.educators_back.repository;

import com.akademia.educators_back.entity.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<QuestionEntity, Long> {
}
