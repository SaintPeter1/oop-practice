package com.ivan.practice.service;

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
    public BusSchedule createSchedule(BusSchedule schedule) {
        return repository.save(schedule);
    }

    // Оновити існуючий розклад
    public BusSchedule updateSchedule(Long id, BusSchedule updatedSchedule) {
        BusSchedule existing = getScheduleById(id);
        existing.setDestination(updatedSchedule.getDestination());
        existing.setBusNumber(updatedSchedule.getBusNumber());
        existing.setDepartureTime(updatedSchedule.getDepartureTime());
        existing.setCarrier(updatedSchedule.getCarrier());
        existing.setTripDuration(updatedSchedule.getTripDuration());
        existing.setLicensePlate(updatedSchedule.getLicensePlate());
        return repository.save(existing);
    }

    // Видалити розклад за ID
    public void deleteSchedule(Long id) {
        repository.deleteById(id);
    }
}
