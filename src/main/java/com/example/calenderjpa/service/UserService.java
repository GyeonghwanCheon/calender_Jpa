package com.example.calenderjpa.service;

import com.example.calenderjpa.dto.userdto.SignUpResponseDto;
import com.example.calenderjpa.dto.userdto.UserResopnseDto;
import com.example.calenderjpa.entity.User;
import com.example.calenderjpa.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // 유저 생성
    public SignUpResponseDto signUp(String username, String email) {

        User user = new User(username,email);

        User savedUser  = userRepository.save(user);

        return new SignUpResponseDto(savedUser.getId(), savedUser.getUsername(), savedUser.getEmail());
    }

    public UserResopnseDto findById(Long id) {

        Optional<User> optinalUser = userRepository.findById(id);

        // NPE 방지
        if(optinalUser.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }

        User findUser = optinalUser.get();

        return new UserResopnseDto(findUser.getUsername(), findUser.getEmail());
    }

    public List<SignUpResponseDto> findAll() {
        return userRepository.findAll().stream().map(SignUpResponseDto::toDto).toList();
    }

    public void delete(Long id) {

        User findUser = userRepository.findByIdOrElseThrow(id);

        userRepository.delete(findUser);
    }
}
