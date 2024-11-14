package com.example.calenderjpa.repository;

import com.example.calenderjpa.entity.Calender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalenderRepository extends JpaRepository<Calender, Long> {

}
