package com.example.calenderjpa.controller;


import com.example.calenderjpa.dto.calenderdto.CalenderRequestDto;
import com.example.calenderjpa.dto.calenderdto.CalenderResponseDto;
import com.example.calenderjpa.service.CalenderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calenders")
@RequiredArgsConstructor
public class CalenderController {

    private final CalenderService calenderService;

    // 일정 생성
    @PostMapping
    public ResponseEntity<CalenderResponseDto> save(@RequestBody CalenderRequestDto requestDto) {

        CalenderResponseDto calenderResponseDto = calenderService.save(requestDto.getUsername() ,requestDto.getTitle(), requestDto.getContents());

        return new ResponseEntity<>(calenderResponseDto, HttpStatus.CREATED);
    }

    //일정 전체 조회
    @GetMapping
    public ResponseEntity<List<CalenderResponseDto>> findAll() {
        List<CalenderResponseDto> calenderResponseDtoList = calenderService.findAll();

        return new ResponseEntity<>(calenderResponseDtoList, HttpStatus.OK);
    }

    //일정 단건 조회
    @GetMapping("/{id}")
    public ResponseEntity<CalenderResponseDto> findById(@PathVariable Long id) {
        CalenderResponseDto calenderResponseDto = calenderService.findById(id);

        return new ResponseEntity<>(calenderResponseDto, HttpStatus.OK);
    }

//    //일정 수정
//    @PatchMapping("/{id}")
//    public ResponseEntity<Void> updateCalender(@PathVariable Long id, @RequestBody CalenderRequestDto requestDto) {
//
//        calenderService.updateCalender(id, requestDto.getTitle(), requestDto.getContents());
//
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

//    // 선택 일정 삭제
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> delete(@PathVariable Long id) {
//        calenderService.delete(id);
//
//        return new ResponseEntity<>(HttpStatus.OK);
//    }


}
