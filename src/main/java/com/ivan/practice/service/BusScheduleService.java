package com.ivan.practice.service;

import com.ivan.practice.dto.BusScheduleDTO;
import com.ivan.practice.entity.BusSchedule;
import com.ivan.practice.repository.BusScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusScheduleService {

    private final BusScheduleRepository repository;

    public BusScheduleService(BusScheduleRepository repository) {
        this.repository = repository;
    }

    // Отримати всі розклади
    public List<BusSchedule> getAllSchedules() {
        return repository.findAll();
    }

    // Отримати розклад за ID
    public BusSchedule getScheduleById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Розклад з ID " + id + " не знайдено."));
    }

    // Додати новий розклад
    public BusSchedule createSchedule(BusScheduleDTO scheduleDTO) {
        // Перетворення DTO в сутність
        BusSchedule schedule = convertToEntity(scheduleDTO);
        // Збереження сутності
        return repository.save(schedule);
    }

    // Оновити існуючий розклад
    public BusSchedule updateSchedule(Long id, BusScheduleDTO updatedScheduleDTO) {
        // Перевірка існування розкладу
        BusSchedule existing = getScheduleById(id);
        // Оновлення сутності на основі DTO
        updateEntityFromDTO(existing, updatedScheduleDTO);
        // Збереження оновленої сутності
        return repository.save(existing);
    }

    // Видалити розклад за ID
    public void deleteSchedule(Long id) {
        // Перевірка існування розкладу перед видаленням
        if (!repository.existsById(id)) {
            throw new RuntimeException("Розклад з ID " + id + " не знайдено.");
        }
        repository.deleteById(id);
    }

    // Метод для перетворення DTO в сутність
    private BusSchedule convertToEntity(BusScheduleDTO dto) {
        BusSchedule schedule = new BusSchedule();
        schedule.setRoute(dto.getRoute());
        schedule.setDepartureTime(dto.getDepartureTime());
        schedule.setArrivalTime(dto.getArrivalTime());
        schedule.setBusNumber(dto.getBusNumber());
        return schedule;
    }

    // Метод для оновлення сутності на основі DTO
    private void updateEntityFromDTO(BusSchedule entity, BusScheduleDTO dto) {
        entity.setRoute(dto.getRoute());
        entity.setDepartureTime(dto.getDepartureTime());
        entity.setArrivalTime(dto.getArrivalTime());
        entity.setBusNumber(dto.getBusNumber());
    }
}
