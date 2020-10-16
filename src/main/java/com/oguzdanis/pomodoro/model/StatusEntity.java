package com.oguzdanis.pomodoro.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "status")
@Data
public class StatusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "status_id")
    private Long statusId;
    @Column(name = "name")
    private String name;

}
