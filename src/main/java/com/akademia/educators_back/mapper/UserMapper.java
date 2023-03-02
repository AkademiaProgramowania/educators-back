package com.akademia.educators_back.mapper;

import com.akademia.educators_back.to.UserTo;
import com.akademia.educators_back.entity.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserEntity toUserEntity(UserTo userTo){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(userTo.getId());
        userEntity.setName(userTo.getName());
        userEntity.setPassword(userTo.getPassword());
        return userEntity;
    }

    public UserTo toUserTO(UserEntity userEntity){
        UserTo userTo = new UserTo();
        userTo.setId(userEntity.getId());
        userTo.setName(userEntity.getName());
        userTo.setPassword(userEntity.getPassword());
        return userTo;
    }
}
