package com.DongLee99.book.springboot.web;

import com.DongLee99.book.springboot.domain.user.User;
import com.DongLee99.book.springboot.service.LoginService;
import com.DongLee99.book.springboot.service.PostsService;
import com.DongLee99.book.springboot.web.dto.LoginJoinRequestDto;
import com.DongLee99.book.springboot.web.dto.LoginRequestDto;
import com.DongLee99.book.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class LoginController {

    private final LoginService loginService;

    @PostMapping("/signup")
    public User save(@RequestBody LoginJoinRequestDto requestDto) {
        return loginService.save(requestDto);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequestDto requestDto) {
        return loginService.login(requestDto);
    }

}
