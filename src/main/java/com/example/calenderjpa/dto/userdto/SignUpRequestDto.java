package com.example.calenderjpa.dto.userdto;

import lombok.Getter;

@Getter
public class SignUpRequestDto {

    private final String username; //유저 이름

    private final String password; //유저 비밀번호

    private final String email; //유저 이메일

    public SignUpRequestDto(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
