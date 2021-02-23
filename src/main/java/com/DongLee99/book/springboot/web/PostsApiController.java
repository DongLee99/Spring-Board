package com.DongLee99.book.springboot.web;


import com.DongLee99.book.springboot.domain.user.User;
import com.DongLee99.book.springboot.service.PostsService;
import com.DongLee99.book.springboot.web.dto.LoginResponseDto;
import com.DongLee99.book.springboot.web.dto.PostsResponseDto;
import com.DongLee99.book.springboot.web.dto.PostsSaveRequestDto;
import com.DongLee99.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;
    private final HttpSession httpSession;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        LoginResponseDto user = (LoginResponseDto) httpSession.getAttribute("user");
        requestDto.setAuthor(user.getEmail());
        return postsService.save(requestDto,user);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
        return postsService.update(id, requestDto);
    }
    @DeleteMapping("/api/v1/posts/{id}")
    public Long Delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }


}
