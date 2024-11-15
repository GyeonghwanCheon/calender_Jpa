package com.example.calenderjpa.dto.userdto;

import com.example.calenderjpa.entity.User;
import lombok.Getter;

@Getter
public class SignUpResponseDto {

    private final Long id; //식별자

    private final String username; //유저 이름

    private final String email; //유저 이메일

    public SignUpResponseDto(Long id, String username ,String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }

    public static SignUpResponseDto toDto(User user){
        return new SignUpResponseDto(user.getId(), user.getUsername() ,user.getEmail());
    }
}
