package com.oguzdanis.pomodoro.service.Impl;

import com.oguzdanis.pomodoro.model.UserEntity;
import com.oguzdanis.pomodoro.repository.UserRepository;
import com.oguzdanis.pomodoro.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements IUserService, UserDetailsService{

    @Autowired
    UserRepository userRepository;

    @Autowired
    IUserService userService;

    private PasswordEncoder bcryptEncoder;

    @Override
    public ResponseEntity<List<UserEntity>> AllUser() {
        List<UserEntity> userEntityList = userRepository.findAll();
        if (userEntityList.size() == 0){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userEntityList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserEntity> userFindById(Long userId) {
        UserEntity userEntity = userRepository.findByUserId(userId);
        if (userEntity == null)
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity(userEntity, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserEntity> createUser(UserEntity user) {
        user.setPassword(bcryptEncoder.encode(user.getPassword()));
        return new ResponseEntity<UserEntity>(userRepository.save(user), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserEntity> updateUser(UserEntity user) {
        UserEntity userEntity = userRepository.findByUserId(user.getUserId());
        if (userEntity == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userRepository.save(user), HttpStatus.OK);
    }

    @Override
    public ResponseEntity deleteUser(Long userId) {
        UserEntity user = userRepository.findByUserId(userId);
        if (user != null) {
            userRepository.delete(user);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @Override
    public UserEntity getUserByUserName(String username) {
        UserEntity usernameEntity = userRepository.findByUsername(username);
        return (usernameEntity != null) ? usernameEntity : null;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(s);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + s);
        }
        return new User(user.getSurname(), user.getPassword(), new ArrayList<>());
    }
}
