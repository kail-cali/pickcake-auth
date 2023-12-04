package com.bloger.blog.domain;

public class Member {
    private Long id;
    private String name;
    private String mail;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMail() {
        return mail;
    }

    public void setName(String name) {
        this.name = name;
    }
}
