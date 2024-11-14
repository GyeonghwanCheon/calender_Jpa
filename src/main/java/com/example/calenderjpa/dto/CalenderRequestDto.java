package com.example.calenderjpa.dto;

import lombok.Getter;

@Getter
public class CalenderRequestDto {

    private final String username;

    private final String title;

    private final String contents;


    public CalenderRequestDto(String username, String title, String contents) {
        this.username = username;
        this.title = title;
        this.contents = contents;
    }
}
