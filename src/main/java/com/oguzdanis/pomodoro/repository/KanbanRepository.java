package com.oguzdanis.pomodoro.repository;

import com.oguzdanis.pomodoro.model.KanbanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KanbanRepository extends JpaRepository<KanbanEntity, Long> {

    List<KanbanEntity> findAllBy();

    KanbanEntity findAllByKanbanId(Long kanbanId);

}
