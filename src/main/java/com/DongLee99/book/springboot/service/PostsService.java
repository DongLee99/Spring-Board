package com.DongLee99.book.springboot.service;

import com.DongLee99.book.springboot.domain.UserRepository;
import com.DongLee99.book.springboot.domain.posts.Posts;
import com.DongLee99.book.springboot.domain.posts.PostsRepository;
import com.DongLee99.book.springboot.domain.user.User;
import com.DongLee99.book.springboot.web.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpSession;
import java.io.Writer;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;
    private final UserRepository userRepository;
    private final HttpSession httpSession;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto,LoginResponseDto user ) {
        User writer = userRepository.findByEmail(user.getEmail());
        return postsRepository.save(requestDto.toEntitiy(writer)).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id = " +id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }
    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id =" + id));
        postsRepository.delete(posts);
    }

    public PostsResponseDto findById( Long id){
        Posts entity = postsRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id = " +id));

        return new PostsResponseDto(entity);
    }

}
