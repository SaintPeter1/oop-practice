package com.ivan.practice.repository;

import com.ivan.practice.entity.BusSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BusScheduleRepository extends JpaRepository<BusSchedule, Long> {
    // JpaRepository надає готові методи, такі як findAll(), findById(), save(), deleteById() тощо
}
