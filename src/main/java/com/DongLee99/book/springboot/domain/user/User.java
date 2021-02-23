package com.DongLee99.book.springboot.domain.user;


import com.DongLee99.book.springboot.domain.BaseTimeEntity;
import com.fasterxml.jackson.databind.ser.Serializers;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@NoArgsConstructor
@Entity

public class User extends BaseTimeEntity {


    @Column(nullable = false)
    private String password;

    @Column(nullable = true)
    private String email;

    @Builder
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }


}
