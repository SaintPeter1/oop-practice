package com.ivan.practice.controller;

import com.ivan.practice.entity.BusSchedule;
import com.ivan.practice.service.BusScheduleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedules")
public class BusScheduleController {
    private final BusScheduleService service;

    public BusScheduleController(BusScheduleService service) {
        this.service = service;
    }

    // Отримати всі розклади
    @GetMapping
    public List<BusSchedule> getAllSchedules() {
        return service.getAllSchedules();
    }

    // Отримати розклад за ID
    @GetMapping("/{id}")
    public ResponseEntity<BusSchedule> getScheduleById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getScheduleById(id));
    }

    // Додати новий розклад
    @PostMapping
    public ResponseEntity<BusSchedule> createSchedule(@RequestBody BusSchedule schedule) {
        return ResponseEntity.ok(service.createSchedule(schedule));
    }

    // Оновити розклад
    @PutMapping("/{id}")
    public ResponseEntity<BusSchedule> updateSchedule(@PathVariable Long id, @RequestBody BusSchedule schedule) {
        return ResponseEntity.ok(service.updateSchedule(id, schedule));
    }

    // Видалити розклад
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id) {
        service.deleteSchedule(id);
        return ResponseEntity.noContent().build();
    }
}
