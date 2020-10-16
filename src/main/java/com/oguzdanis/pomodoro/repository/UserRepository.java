package com.oguzdanis.pomodoro.repository;

import com.oguzdanis.pomodoro.model.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    List<UserEntity> findAll();

    UserEntity findByUserId(Long userId);

    UserEntity findByUsername(String username);

}
