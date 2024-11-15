package com.example.calenderjpa.dto.userdto;

import com.example.calenderjpa.entity.User;
import lombok.Getter;

@Getter
public class UserResopnseDto {
    private final String username;

    private final String email;

    public UserResopnseDto(String username, String email) {
        this.username = username;
        this.email = email;
    }

}
