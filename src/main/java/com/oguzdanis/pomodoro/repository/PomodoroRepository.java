package com.oguzdanis.pomodoro.repository;

import com.oguzdanis.pomodoro.model.PomodoroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PomodoroRepository extends JpaRepository<PomodoroEntity, Long> {

    List<PomodoroEntity> findAll();

    PomodoroEntity findByPomodoroId(Long pomodoroId);

}
