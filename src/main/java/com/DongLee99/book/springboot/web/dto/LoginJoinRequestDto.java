package com.DongLee99.book.springboot.web.dto;

import com.DongLee99.book.springboot.domain.posts.Posts;
import com.DongLee99.book.springboot.domain.user.User;
import lombok.Builder;
import lombok.Getter;

@Getter
public class LoginJoinRequestDto {
    private String email;
    private String password;

    @Builder
    public LoginJoinRequestDto (String email, String password) {
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
