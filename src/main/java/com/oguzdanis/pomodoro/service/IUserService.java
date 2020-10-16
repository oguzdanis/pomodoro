package com.oguzdanis.pomodoro.service;

import com.oguzdanis.pomodoro.model.UserEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IUserService {
    ResponseEntity<List<UserEntity>> AllUser();

    ResponseEntity<UserEntity> userFindById(Long userId);

    ResponseEntity<UserEntity> createUser(UserEntity user);

    ResponseEntity<UserEntity> updateUser(UserEntity user);

    ResponseEntity deleteUser(Long userId);

    UserEntity getUserByUserName(String username);
}
