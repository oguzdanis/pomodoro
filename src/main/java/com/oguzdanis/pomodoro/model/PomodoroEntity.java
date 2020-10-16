package com.oguzdanis.pomodoro.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pomodoro")
@Data
public class PomodoroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "pomodoro_id")
    private Long pomodoroId;
    @Column(name = "date")
    private Date date;

}
