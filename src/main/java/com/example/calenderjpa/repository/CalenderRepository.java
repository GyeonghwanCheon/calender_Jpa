package com.example.calenderjpa.repository;

import com.example.calenderjpa.entity.Calender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public interface CalenderRepository extends JpaRepository<Calender, Long> {

    default Calender findByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id)
                );
    }
}
