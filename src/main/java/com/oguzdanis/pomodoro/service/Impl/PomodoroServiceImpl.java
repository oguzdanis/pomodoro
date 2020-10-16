package com.oguzdanis.pomodoro.service.Impl;

import com.oguzdanis.pomodoro.model.PomodoroEntity;
import com.oguzdanis.pomodoro.repository.PomodoroRepository;
import com.oguzdanis.pomodoro.service.IPomodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PomodoroServiceImpl implements IPomodoService {

    @Autowired
    PomodoroRepository pomodoroRepository;

    @Override
    public List<PomodoroEntity> findAllPomodoro() {
        return pomodoroRepository.findAll();
    }

    @Override
    public PomodoroEntity findPomodoroById(Long pomodoroId) {
        return pomodoroRepository.findByPomodoroId(pomodoroId);
    }

    @Override
    public PomodoroEntity createPomodoro(PomodoroEntity pomodoro) {
        return pomodoroRepository.save(pomodoro);
    }

    @Override
    public PomodoroEntity updatePomodoro(PomodoroEntity pomodoro) {
        return pomodoroRepository.save(pomodoro);
    }

    @Override
    public void deletePomodoro(Long pomodoroId) {
        PomodoroEntity pomodoroEntity = pomodoroRepository.findByPomodoroId(pomodoroId);
        pomodoroRepository.delete(pomodoroEntity);
    }
}
