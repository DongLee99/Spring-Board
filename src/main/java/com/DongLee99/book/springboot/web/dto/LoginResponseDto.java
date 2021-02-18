package com.DongLee99.book.springboot.web.dto;

import com.DongLee99.book.springboot.domain.user.User;

public class LoginResponseDto {
    private Long id;
    private String email;
    private String password;

    public LoginResponseDto(User entity){
        this.email = entity.getEmail();
        this.password = entity.getPassword();
    }
}
