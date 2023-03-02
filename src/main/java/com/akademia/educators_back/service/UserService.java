package com.akademia.educators_back.service;

import com.akademia.educators_back.entity.UserEntity;
import com.akademia.educators_back.repository.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity> getUser() {
        return userRepository.findAll();
        //UserEntity user1 = new UserEntity(3840, "User1");
    }

    public void addUser(UserEntity userEntity) {
        userRepository.save(userEntity);
    }
}
