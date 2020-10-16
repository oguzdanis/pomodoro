package com.oguzdanis.pomodoro.service.Impl;

import com.oguzdanis.pomodoro.model.KanbanEntity;
import com.oguzdanis.pomodoro.model.UserEntity;
import com.oguzdanis.pomodoro.repository.KanbanRepository;
import com.oguzdanis.pomodoro.service.IKanbanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KanbanServiceImpl implements IKanbanService {

    @Autowired
    KanbanRepository kanbanRepository;

    @Override
    public ResponseEntity<List<KanbanEntity>> findAllKanban() {
        List<KanbanEntity> kanbanEntityList = kanbanRepository.findAllBy();
        if (kanbanEntityList.size() == 0) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(kanbanEntityList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<KanbanEntity> findKanbanById(Long kanbanId) {
        KanbanEntity kanbanEntity = kanbanRepository.findAllByKanbanId(kanbanId);
        if (kanbanEntity == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(kanbanEntity, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<KanbanEntity> createKanban(KanbanEntity kanban) {
        kanbanRepository.save(kanban);
        return new ResponseEntity<>(kanbanRepository.save(kanban), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<KanbanEntity> updateKanban(KanbanEntity kanban) {
        if (kanban.getKanbanId() == null || kanban.getKanbanName() == null || kanban.getCDate() == null)
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(kanbanRepository.save(kanban), HttpStatus.OK);
    }

    @Override
    public ResponseEntity deleteKanban(Long kanbanId) {
        KanbanEntity kanbanEntity = kanbanRepository.findAllByKanbanId(kanbanId);
        if (kanbanEntity == null)
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        kanbanRepository.delete(kanbanEntity);
        return new ResponseEntity(HttpStatus.OK);
    }
}
