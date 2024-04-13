package co.pickcake.auth.authdomain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "email", "age" })
public class Member {

    @Id @GeneratedValue
    @Column(name ="member_id")
    private Long id;
    private String email;
    private String name;
    private int age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="team_id")
    private Team team;

    public Member(String  email, String  name, int age, Team team) {
        this.email = email;
        this.name  = name;
        this.age = age;
        if (team != null) {
            changeTeam(team);
        }
    }
    public void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }


    public static Member create(String email, String name) {
        Member member = new Member();
        member.email = email;
        member.name = name;
        return member;
    }



}
