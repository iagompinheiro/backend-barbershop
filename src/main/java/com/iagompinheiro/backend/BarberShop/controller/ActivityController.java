package com.iagompinheiro.backend.BarberShop.controller;

import com.iagompinheiro.backend.BarberShop.domain.domainActivity.Activity;
import com.iagompinheiro.backend.BarberShop.dto.ActivityDto;
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
    public ResponseEntity<Activity> create(@RequestBody ActivityDto activityDto) {
        Activity newActivity = activityService.create(activityDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Activity>> getAll() {
        List<Activity> allActivities = activityService.getAll();
        return ResponseEntity.ok(allActivities);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Activity> activityById(@PathVariable Long id) {
        Activity activityById = activityService.activityById(id);
        return ResponseEntity.ok(activityById);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Activity> update(@PathVariable Long id, @RequestBody ActivityDto activityDto) {
        Activity newActivity = activityService.update(id, activityDto);
        return ResponseEntity.ok(newActivity);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable Long id) {
        activityService.deleteById(id);

    }


}
