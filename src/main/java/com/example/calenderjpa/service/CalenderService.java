package com.example.calenderjpa.service;

import com.example.calenderjpa.dto.CalenderResponseDto;
import com.example.calenderjpa.entity.Calender;
import com.example.calenderjpa.repository.CalenderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CalenderService {

    private final CalenderRepository calenderRepository;

    // 일정 생성
    public CalenderResponseDto save(String username, String title, String contents ) {

        Calender calender = new Calender(username, title, contents);

        Calender savedCalender = calenderRepository.save(calender);

        return new CalenderResponseDto(
                savedCalender.getId(), savedCalender.getUsername(), savedCalender.getTitle(),
                savedCalender.getContents(), savedCalender.getCreateAt(), savedCalender.getModifiedAt()
        );
    }

    public List<CalenderResponseDto> findAll() {
        return calenderRepository.findAll().stream().map(CalenderResponseDto::toDto).toList();
    }


    public CalenderResponseDto findById(Long id) {
        Calender findCalender = calenderRepository.findByIdOrElseThrow(id);

        return new CalenderResponseDto(
                findCalender.getId() ,findCalender.getUsername(), findCalender.getTitle(),
                findCalender.getContents(), findCalender.getCreateAt(), findCalender.getModifiedAt());
    }
}
