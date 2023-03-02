package com.akademia.educators_back.controller;

import com.akademia.educators_back.entity.UserEntity;
import com.akademia.educators_back.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /*@RequestMapping(path = "/api/users", method = RequestMethod.GET)
        public UserEntity getUser(){
            System.out.println("Ktos pobiera uzytkownika.");
            UserEntity user1 = new UserEntity(3840, "User1");
            return user1;
        }

         */
    @GetMapping("/api/users")
    public ResponseEntity<List<UserEntity>> getUsers(){
        //ResponseEntity<UserEntity> response = new ResponseEntity<>(user1, HttpStatus.OK);
        return ResponseEntity.ok()
                .body(userService.getUser());
    }

    @PostMapping("/api/users")
    void createUser(@RequestBody UserEntity userEntity){
        System.out.println(userEntity);
        userService.addUser(userEntity);
    }

    //statusy tworzonych obiektow - rest api

}
