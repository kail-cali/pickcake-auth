package com.bloger.blog.authdomain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Member {

    @Id @GeneratedValue
    private Long id;

    private String email;
    private String name;

    protected Member() {

    }

    public static Member create(String email, String name) {
        Member member = new Member();
        member.email = email;
        member.name = name;
        return member;
    }



}
