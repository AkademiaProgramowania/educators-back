package com.akademia.educators_back.repository;


import com.akademia.educators_back.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
