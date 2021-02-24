package com.DongLee99.book.springboot.domain.likes;

import com.DongLee99.book.springboot.domain.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LikesRepository extends JpaRepository<Posts,Long> {

}
