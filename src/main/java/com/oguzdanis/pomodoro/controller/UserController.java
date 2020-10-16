package com.oguzdanis.pomodoro.controller;

import com.oguzdanis.pomodoro.model.UserEntity;
import com.oguzdanis.pomodoro.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService userService;

    @GetMapping
    public ResponseEntity<List<UserEntity>> inquireAllUser(){
        return userService.AllUser();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserEntity> inquireUserById(@PathVariable Long userId){
        return userService.userFindById(userId);
    }

    @PostMapping
    public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user){
        return userService.createUser(user);
    }

    @PutMapping
    public ResponseEntity<UserEntity> updateUser(@RequestBody UserEntity user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity deleteUser(@PathVariable Long userId){
        return userService.deleteUser(userId);
    }
}
