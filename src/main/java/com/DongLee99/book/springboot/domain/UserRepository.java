package com.DongLee99.book.springboot.domain;

import com.DongLee99.book.springboot.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u from User u  where u.email = :email and u.password = :password")
    User findMember(String email, String password);
    Optional<User> findByEmail(String email);

}