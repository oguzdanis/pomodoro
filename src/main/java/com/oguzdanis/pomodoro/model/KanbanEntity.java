package com.oguzdanis.pomodoro.model;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.util.Date;

@Entity
@Table(name = "kanban")
@Data
public class KanbanEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "kanban_id")
    private Long kanbanId;
    @Column(name = "kanban_name")
    private String kanbanName;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date cDate;
}
