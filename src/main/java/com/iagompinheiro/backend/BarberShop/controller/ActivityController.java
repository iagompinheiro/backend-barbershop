package com.iagompinheiro.backend.BarberShop.controller;

import com.iagompinheiro.backend.BarberShop.domain.domainActivity.Activity;
import com.iagompinheiro.backend.BarberShop.dto.ActivityDto;
import com.iagompinheiro.backend.BarberShop.exceptions.ActivityException;
import com.iagompinheiro.backend.BarberShop.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/activities")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @PostMapping
    public ResponseEntity<Activity> create(@RequestBody ActivityDto activityDto) throws ActivityException {
       try {
           Activity newActivity = activityService.create(activityDto);
           return new ResponseEntity<>(HttpStatus.CREATED);
       }catch (Exception e) {
           throw new ActivityException("Não foi possível criar uma atividade, data e horário já utilizados.");
       }
    }

    @GetMapping
    public ResponseEntity<List<Activity>> getAll() throws ActivityException {
       try {
           List<Activity> allActivities = activityService.getAll();
           return ResponseEntity.ok(allActivities);
       }catch (Exception e) {
           throw new ActivityException("Não foi possível listar as ativiades.");
       }

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Activity> activityById(@PathVariable Long id) throws ActivityException {
       try {
           Activity activityById = activityService.activityById(id);
           return ResponseEntity.ok(activityById);
       }catch (Exception e) {
           throw new ActivityException("Não foi possível encontrar atividade.");
       }

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Activity> update(@PathVariable Long id, @RequestBody ActivityDto activityDto) throws ActivityException {
        try {
            Activity newActivity = activityService.update(id, activityDto);
            return ResponseEntity.ok(newActivity);
        }catch (Exception e) {
            throw new ActivityException("Não foi possível atualizar a atividade.");
        }
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Long id) throws ActivityException {
        try {
            activityService.deleteById(id);
        }catch (Exception e) {
            throw new ActivityException("Atividade não encontrada.");
        }
    }


}
