package com.DongLee99.book.springboot.service;


import com.DongLee99.book.springboot.domain.UserRepository;
import com.DongLee99.book.springboot.domain.user.User;
import com.DongLee99.book.springboot.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class LoginService {
    private final UserRepository userRepository;

    @Transactional
    public User save(LoginJoinRequestDto requestDto) {
        return userRepository.save(requestDto.toEntitiy());
    }
    @Transactional
    public Long login(LoginRequestDto requestDto) {
        try {
            LoginResponseDto user = findById(requestDto.toEntitiy().getEmail(),requestDto.toEntitiy().getPassword());
            return requestDto.toEntitiy().getId();
        } catch (IllegalArgumentException e) {
            new IllegalArgumentException("해당 게시글이 없습니다. email = " + requestDto.toEntitiy().getEmail());
        }

        return requestDto.toEntitiy().getId();
    }

    public LoginResponseDto findById(String email, String password){
        try {
            User entity = userRepository.findMember(email, password);
            return new LoginResponseDto(entity);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("해당 아이디가 없습니다. email = " + email);
        }
    }
}
