package com.DongLee99.book.springboot.web.dto;

import com.DongLee99.book.springboot.domain.posts.Posts;
import com.DongLee99.book.springboot.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsSaveRequestDto {
    private User writer;
    private String title;
    private String content;
    private String author;
    @Builder
    public PostsSaveRequestDto(String title, String content){
        this.title = title;
        this.content = content;
    }

    public void setAuthor(String Author) {
        this.author = Author;
    }
    public Posts toEntitiy() {
        return Posts.builder()
                .writer(writer)
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
