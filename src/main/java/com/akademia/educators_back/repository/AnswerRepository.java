package com.akademia.educators_back.repository;

import com.akademia.educators_back.entity.AnswerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<AnswerEntity, Long> {
}
