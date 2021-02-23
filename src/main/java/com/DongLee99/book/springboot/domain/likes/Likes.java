package com.DongLee99.book.springboot.domain.likes;


import com.DongLee99.book.springboot.domain.BaseTimeEntity;
import com.DongLee99.book.springboot.domain.posts.Posts;
import com.DongLee99.book.springboot.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Likes extends BaseTimeEntity {

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Posts posts;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private User user;

    @Builder
    public Likes(Posts posts, User user){
        this.posts = posts;
        this.user = user;
    }

}
