package com.akademia.educators_back.mapper;

import com.akademia.educators_back.entity.UserEntity;
import com.akademia.educators_back.to.UserTo;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserTo userEntityToUserTO(UserEntity userEntity) {
        UserTo userTo = new UserTo(userEntity.getId(), userEntity.getName());
        return userTo;
    }

    public UserEntity userToToUserEntity(UserTo userTo) {
        UserEntity user = new UserEntity(userTo.getId(), userTo.getName());
        return user;
    }

}
