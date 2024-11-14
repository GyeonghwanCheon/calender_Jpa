package com.example.calenderjpa.controller;

import com.example.calenderjpa.dto.userdto.SignUpRequestDto;
import com.example.calenderjpa.dto.userdto.SignUpResponseDto;
import com.example.calenderjpa.dto.userdto.UserResopnseDto;
import com.example.calenderjpa.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 유저 생성
    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpRequestDto requestDto) {

        SignUpResponseDto signUpResponseDto = userService.signUp(requestDto.getUsername(), requestDto.getPassword() ,requestDto.getEmail());

        return new ResponseEntity<>(signUpResponseDto, HttpStatus.CREATED);
    }

    // 특정 유저 조회
    @GetMapping("/{id}")
    public ResponseEntity<UserResopnseDto> findById(@PathVariable Long id) {
        UserResopnseDto userResopnseDto = userService.findById(id);

        return new ResponseEntity<>(userResopnseDto, HttpStatus.OK);
    }

    // 유저 전체 조회
    @GetMapping
    public ResponseEntity<List<SignUpResponseDto>> findAll() {

        List<SignUpResponseDto> userSignUpResponseDto = userService.findAll();

        return new ResponseEntity<>(userSignUpResponseDto, HttpStatus.OK);
    }

    // 유저 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        userService.delete(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }



}
