package com.DongLee99.book.springboot.web.dto;

import com.DongLee99.book.springboot.domain.user.User;

public class LoginRequestDto {
    private String password;
    private String email;

    public LoginRequestDto (String email, String password) {
        this.email = email;
        this.password = password;
    }
    public User toEntitiy() {
        return User.builder()
                .email(email)
                .password(password)
                .build();
    }
}
