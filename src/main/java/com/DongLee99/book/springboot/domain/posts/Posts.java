package com.DongLee99.book.springboot.domain.posts;


import com.DongLee99.book.springboot.domain.BaseTimeEntity;
import com.DongLee99.book.springboot.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@DynamicUpdate
public class Posts extends BaseTimeEntity {

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private User writer;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(User writer, String title, String content, String author){
        this.writer = writer;
        this.title = title;
        this.content= content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
