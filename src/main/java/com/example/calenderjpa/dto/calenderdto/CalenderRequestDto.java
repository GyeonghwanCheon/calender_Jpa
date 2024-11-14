package com.example.calenderjpa.dto.calenderdto;

import lombok.Getter;

@Getter
public class CalenderRequestDto {

    // 어떤 회원이 작성했는지 정보를 담기 위해
    private final String username;

    private final String title;

    private final String contents;


    public CalenderRequestDto(String username, String title, String contents) {
        this.username = username;
        this.title = title;
        this.contents = contents;
    }

}
