package com.ivan.practice.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "bus_schedule")
public class BusSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String destination;
    private String busNumber;
    private LocalDateTime departureTime;
    private String carrier;
    private int tripDuration; // у хвилинах
    private String licensePlate;

    // Гетери та сетери
}

    public BusSchedule(String destination, String busNumber, LocalDateTime departureTime,
                       String carrier, int tripDuration, String licensePlate) {
        this.destination = destination;
        this.busNumber = busNumber;
        this.departureTime = departureTime;
        this.carrier = carrier;
        this.tripDuration = tripDuration;
        this.licensePlate = licensePlate;
    }

    public String getDestination() {
        return destination;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public String getCarrier() {
        return carrier;
    }

    public int getTripDuration() {
        return tripDuration;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    @Override
    public String toString() {
        return String.format("Платформа №4: %s -> %s | Відправлення: %s | Перевізник: %s | Тривалість: %d хв | Номерний знак: %s",
                busNumber, destination, departureTime, carrier, tripDuration, licensePlate);
    }
}
