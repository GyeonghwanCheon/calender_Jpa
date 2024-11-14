package com.example.calenderjpa.dto;

public class UpdateCalenderRequsetDto {

    private final String title;

    private final String contents;

    public UpdateCalenderRequsetDto(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}
