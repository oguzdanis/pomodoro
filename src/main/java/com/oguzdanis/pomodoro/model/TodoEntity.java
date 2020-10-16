package com.oguzdanis.pomodoro.model;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "todo")
@Data
public class TodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "todo_id")
    private Long todoId;
    @Column(name = "description")
    private String description;
    @Column(name = "title")
    private String title;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;
    @ManyToOne
    @JoinColumn(name = "status_id")
    private StatusEntity statusEntity;
    @ManyToOne
    @JoinColumn(name = "pomodoro_id")
    private PomodoroEntity pomodoroEntity;
    @ManyToOne
    @JoinColumn(name = "kanban_id")
    private KanbanEntity kanbanEntity;

}
