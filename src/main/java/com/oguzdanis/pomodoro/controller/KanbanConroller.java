package com.oguzdanis.pomodoro.controller;

import com.oguzdanis.pomodoro.model.KanbanEntity;
import com.oguzdanis.pomodoro.service.IKanbanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kanban")
public class KanbanConroller {

    @Autowired
    IKanbanService kanbanService;

    @GetMapping
    public ResponseEntity<List<KanbanEntity>> inquireAllKanban(){
        return kanbanService.findAllKanban();
    }

    @GetMapping("/{kanbanId}")
    public ResponseEntity<KanbanEntity> inquireKanbanById(@PathVariable Long kanbanId){
        return kanbanService.findKanbanById(kanbanId);
    }

    @PostMapping
    public ResponseEntity<KanbanEntity> createKanban(@RequestBody KanbanEntity kanban){
        return kanbanService.createKanban(kanban);
    }

    @PutMapping
    public ResponseEntity<KanbanEntity> putKanban(@RequestBody KanbanEntity kanban){
        return kanbanService.createKanban(kanban);
    }

    @DeleteMapping("/{kanbanId}")
    public ResponseEntity deleteKanban(@PathVariable Long kanbanId){
        return kanbanService.deleteKanban(kanbanId);
    }



}
