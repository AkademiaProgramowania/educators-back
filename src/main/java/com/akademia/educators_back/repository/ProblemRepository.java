package com.akademia.educators_back.repository;

import com.akademia.educators_back.entity.ProblemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProblemRepository extends JpaRepository<ProblemEntity, Long> {
}
