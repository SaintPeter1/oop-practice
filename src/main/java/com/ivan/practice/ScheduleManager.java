package com.ivan.practice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ScheduleManager {
    private List<BusSchedule> schedules;

    public ScheduleManager() {
        schedules = new ArrayList<>();
    }

    public void addBus(String destination, String busNumber, LocalDateTime departureTime,
                       String carrier, int tripDuration, String licensePlate) {
        schedules.add(new BusSchedule(destination, busNumber, departureTime, carrier, tripDuration, licensePlate));
    }

    public List<BusSchedule> getScheduleForPlatform4() {
        return schedules;
    }

    public void displaySchedule() {
        schedules.forEach(System.out::println);
    }
}
