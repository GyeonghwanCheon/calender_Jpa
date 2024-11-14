package com.example.calenderjpa.dto.calenderdto;

import com.example.calenderjpa.entity.Calender;
import com.example.calenderjpa.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CalenderResponseDto {

    private final Long id; //식별자 id

    private final String username; // 작성자

    private final String title; //할일 제목

    private final String contents; //할일 내용

    private final LocalDateTime createAt; // 작성 날짜

    private final LocalDateTime modifiedAt; // 수정 날짜



    public CalenderResponseDto(Long id, String username ,String title, String contents, LocalDateTime createAt, LocalDateTime modifiedAt) {

        this.id = id;
        this.username = username;
        this.title = title;
        this.contents = contents;
        this.createAt = createAt;
        this.modifiedAt = modifiedAt;
    }

    public static CalenderResponseDto toDto(Calender calender) {

        User writer = calender.getUser();

        return new CalenderResponseDto(calender.getId(), writer.getUsername(), calender.getTitle(), calender.getContents(), calender.getCreateAt(), calender.getModifiedAt());
    }
}
