package com.bloger.blog.authdomain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "teamName"})
public class Team {

    @Id
    @GeneratedValue
    @Column(name ="team_Id")
    private Long id;

    private String teamName;

    @OneToMany
    private List<Member> members = new ArrayList<>();

    public Team(String teamName) {
        this.teamName = teamName;
    }
}
