package com.DongLee99.book.springboot.web;

import com.DongLee99.book.springboot.domain.posts.PostsRepository;
import com.DongLee99.book.springboot.service.PostsService;
import com.DongLee99.book.springboot.web.dto.LoginResponseDto;
import com.DongLee99.book.springboot.web.dto.PostsResponseDto;
import com.DongLee99.book.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;
    private final PostsRepository postsRepository;
    private final HttpSession httpSession;
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postsRepository.findAll());
        LoginResponseDto user = (LoginResponseDto) httpSession.getAttribute("user");
        if (user != null) {
            model.addAttribute("userName", user.getEmail());
        }
        return "index";
    }
    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/signup")
    public String signup(){
        return "signup";
    }

    @GetMapping("/logout")
    public String logout(Model model) {
        httpSession.invalidate();
        model.addAttribute("posts", postsRepository.findAll());
        return "index";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post",dto); // mustache 를 가보면 posts 가 아닌 post
        return "posts-update";
    }
}
