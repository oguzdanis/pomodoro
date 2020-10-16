package com.oguzdanis.pomodoro.service;

import com.oguzdanis.pomodoro.model.KanbanEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IKanbanService {

    ResponseEntity<List<KanbanEntity>> findAllKanban();

    ResponseEntity<KanbanEntity> findKanbanById(Long kanbanId);

    ResponseEntity<KanbanEntity> createKanban(KanbanEntity kanban);

    ResponseEntity<KanbanEntity> updateKanban(KanbanEntity kanban);

    ResponseEntity deleteKanban(Long kanbanId);
}
