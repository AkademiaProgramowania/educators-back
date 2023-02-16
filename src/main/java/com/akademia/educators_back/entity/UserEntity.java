package com.akademia.educators_back.entity;


public class UserEntity {


    private Long id;
    private String name;

    public UserEntity(long id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

