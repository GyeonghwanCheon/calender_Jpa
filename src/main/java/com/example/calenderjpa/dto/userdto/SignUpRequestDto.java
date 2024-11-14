package com.example.calenderjpa.dto.userdto;

import lombok.Getter;

@Getter
public class SignUpRequestDto {

    private final String username; //유저 이름

    private final String email; //유저 이메일

    public SignUpRequestDto(String username, String email) {
        this.username = username;
        this.email = email;
    }
}
