package com.ivan.practice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        ScheduleManager manager = new ScheduleManager();

        // Генеруємо розклад з понеділка по п'ятницю (5 рейсів щодня)
        String[] destinations = {"Київ", "Одеса", "Львів", "Харків", "Дніпро"};
        String[] carriers = {"Автолюкс", "Гюнсел", "Інтертранс", "Скайбус", "Фастлайн"};
        String[] licensePlates = {"AB1234CA", "EC5678HA", "CA9012CE", "CA3456OP", "CA7890CI"};
        int[] durations = {240, 300, 360, 420, 480}; // у хвилинах

        LocalDate startDate = LocalDate.now().with(java.time.DayOfWeek.MONDAY);
        LocalTime[] departureTimes = {
                LocalTime.of(8, 0),
                LocalTime.of(10, 0),
                LocalTime.of(12, 0),
                LocalTime.of(14, 0),
                LocalTime.of(16, 0)
        };

        for (int day = 0; day < 5; day++) { // Понеділок - П'ятниця
            for (int i = 0; i < 5; i++) { // 5 відправок щодня
                manager.addBus(
                        destinations[i],
                        "B" + (day * 5 + i + 1),
                        LocalDateTime.of(startDate.plusDays(day), departureTimes[i]),
                        carriers[i],
                        durations[i],
                        licensePlates[i]
                );
            }
        }

        // Відображення розкладу
        manager.displaySchedule();
    }
}
