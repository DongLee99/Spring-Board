package com.DongLee99.book.springboot.service;


import com.DongLee99.book.springboot.domain.UserRepository;
import com.DongLee99.book.springboot.domain.user.User;
import com.DongLee99.book.springboot.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequiredArgsConstructor
@Service
public class LoginService {
    private final UserRepository userRepository;
    private final HttpSession httpSession;

    @Transactional
    public User save(LoginJoinRequestDto requestDto) {
        return userRepository.save(requestDto.toEntitiy());

    }
    @Transactional
    public String login(LoginRequestDto requestDto) {
        LoginResponseDto loginResponseDto = findById(requestDto.toEntitiy().getEmail(),requestDto.toEntitiy().getPassword());
        System.out.println(loginResponseDto.getId());
        httpSession.setAttribute("user", loginResponseDto);
        return loginResponseDto.getEmail();
    }

    public LoginResponseDto findById(String email, String password){
        try {
            User entity = userRepository.findByEmailAndPassword(email,password);
            if (entity != null) {

                return new LoginResponseDto(entity);
            } else {
                throw new IllegalArgumentException("해당 아이디가 없습니다. email = " + email);
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("해당 아이디가 없습니다. email = " + email);
        }
    }
}
