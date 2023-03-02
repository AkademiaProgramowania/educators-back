package com.akademia.educators_back.controller;

import com.akademia.educators_back.entity.UserEntity;
import com.akademia.educators_back.service.UserService;
import com.akademia.educators_back.to.UserTo;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

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
    public ResponseEntity<List<UserTo>> getUsers() {
        //ResponseEntity<UserEntity> response = new ResponseEntity<>(user1, HttpStatus.OK);
        return ResponseEntity.ok()
                .body(userService.getUsers());
    }

    @PostMapping("/api/users")
    void createUser(@RequestBody UserTo userTo) {
        System.out.println(userTo);
        userService.addUser(userTo);
    }

    @GetMapping("/api/sers/{id}") //PathVariable do wyciagania ze sciezki
    public ResponseEntity<UserTo> findUserById(@PathVariable int id) {
        try {
            return ResponseEntity.ok()
                    .body(userService.getUserById(id));

        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }

    }

    //statusy tworzonych obiektow - rest api
    //optionals

}
