package com.DongLee99.book.springboot.domain;

import com.DongLee99.book.springboot.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    //@Query("select u from User as u  where u.email = ?1 and u.password = ?1")
    User findByEmailAndPassword(String email, String password);

    Optional<User> findByEmail(String email);

}
