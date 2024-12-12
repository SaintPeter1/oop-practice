package com.ivan.practice.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class BusScheduleDTO {

    @NotNull(message = "Route cannot be null")
    @Size(min = 3, max = 100, message = "Route must be between 3 and 100 characters")
    private String route;  // Поле для маршруту

    @NotNull(message = "Departure time cannot be null")
    private LocalDateTime departureTime;  // Поле для часу відправлення

    @NotNull(message = "Arrival time cannot be null")
    private LocalDateTime arrivalTime;  // Поле для часу прибуття

    @NotNull(message = "Bus number cannot be null")
    @Size(min = 1, max = 10, message = "Bus number must be between 1 and 10 characters")
    private String busNumber;  // Поле для номеру автобуса

    // Ось геттери та сеттери для полів

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public void setBusNumber(String busNumber) {
        this.busNumber = busNumber;
    }
}
