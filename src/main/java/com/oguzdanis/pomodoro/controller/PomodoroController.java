package com.oguzdanis.pomodoro.controller;

import com.oguzdanis.pomodoro.model.PomodoroEntity;
import com.oguzdanis.pomodoro.service.IPomodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pomodoro")
public class PomodoroController {

    @Autowired
    IPomodoService pomodoService;

    @GetMapping
    public ResponseEntity<List<PomodoroEntity>> findAllPomodoro(){
        return new ResponseEntity<>(pomodoService.findAllPomodoro(), HttpStatus.OK);
    }
}
