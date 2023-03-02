package com.akademia.educators_back.service;

import com.akademia.educators_back.entity.UserEntity;
import com.akademia.educators_back.mapper.UserMapper;
import com.akademia.educators_back.repository.UserRepository;
import com.akademia.educators_back.to.UserTo;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserService {

    private UserRepository userRepository;
    private UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public List<UserTo> getUsers() {
        List<UserTo> usersTo = new ArrayList<>();
        List<UserEntity> users = userRepository.findAll();
        for (UserEntity user : users) {
            usersTo.add(userMapper.userEntityToUserTO(user));
        }
        return usersTo;
        //UserEntity user1 = new UserEntity(3840, "User1");
    }

    public void addUser(UserTo userTo) {
        userRepository.save(userMapper.userToToUserEntity(userTo));
    }
}
