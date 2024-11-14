package com.example.calenderjpa.service;

import com.example.calenderjpa.dto.calenderdto.CalenderResponseDto;
import com.example.calenderjpa.entity.Calender;
import com.example.calenderjpa.entity.User;
import com.example.calenderjpa.repository.CalenderRepository;
import com.example.calenderjpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CalenderService {

    private final CalenderRepository calenderRepository;
    private final UserRepository userRepository;

    // 일정 생성
    public CalenderResponseDto save(String username, String title, String contents) {

        User findUser = userRepository.findUserByUsernameOrElseThrow(username);

        Calender calender = new Calender(title, contents);
        calender.setUser(findUser);

        Calender savedCalender = calenderRepository.save(calender);

        User writer = calender.getUser();

        return new CalenderResponseDto(
                savedCalender.getId(),  writer.getUsername(), savedCalender.getTitle(),
                savedCalender.getContents(), savedCalender.getCreateAt(), savedCalender.getModifiedAt()
        );
    }

    // 일정 전체 조회
    public List<CalenderResponseDto> findAll() {
        return calenderRepository.findAll().stream().map(CalenderResponseDto::toDto).toList();
    }


    // 일정 단건 조회
    public CalenderResponseDto findById(Long id) {
        Calender findCalender = calenderRepository.findByIdOrElseThrow(id);

        User writer = findCalender.getUser();

        return new CalenderResponseDto(
                findCalender.getId() ,writer.getUsername(), findCalender.getTitle(),
                findCalender.getContents(), findCalender.getCreateAt(), findCalender.getModifiedAt());
    }

    // 일정 수정(제목과 내용만 수정)
    @Transactional
    public void updateCalender(Long id, String title, String contents) {

        Calender findCalender = calenderRepository.findByIdOrElseThrow(id);

        if(findCalender.getId() == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Dose not exist id =" + id);
        }

        if(title == null || contents == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There is no title or content.");
        }

        findCalender.updateCalender(title, contents);
    }

    // 선택 일정 삭제
    public void delete(Long id) {

        Calender findCalender = calenderRepository.findByIdOrElseThrow(id);

        calenderRepository.delete(findCalender);
    }
}
