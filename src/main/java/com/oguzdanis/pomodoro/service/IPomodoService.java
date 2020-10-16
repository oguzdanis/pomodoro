package com.oguzdanis.pomodoro.service;

import com.oguzdanis.pomodoro.model.PomodoroEntity;

import java.util.List;

public interface IPomodoService {

    List<PomodoroEntity> findAllPomodoro();

    PomodoroEntity findPomodoroById(Long pomodoroId);

    PomodoroEntity createPomodoro(PomodoroEntity pomodoro);

    PomodoroEntity updatePomodoro(PomodoroEntity pomodoro);

    void deletePomodoro(Long pomodoroId);
}
