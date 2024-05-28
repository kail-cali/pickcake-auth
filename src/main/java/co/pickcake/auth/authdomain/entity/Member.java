package co.pickcake.auth.authdomain.entity;

import co.pickcake.auth.common.Address;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "member")
@ToString(of = {"id", "email", "age" })
public class Member {

    @Id @GeneratedValue
    @Column(name ="member_id")
    private Long id;
    private String email;
    private String username;
    private String password;

    private int age;

    @Column(name="PROVIDER_TYPE", length=20)
    @Enumerated(EnumType.STRING)
    private ProviderType providerType;

    @Embedded
    private Address address;





    public static Member create(String email, String name) {
        Member member = new Member();
        member.email = email;
        member.username = name;
        return member;
    }

    public static Member create(String email, String name, String password) {
        Member member = new Member();
        member.email = email;
        member.username = name;
        member.password = password;
        return member;
    }

    public static Member create(String email, String name, String password, int age) {
        Member member = new Member();
        member.email = email;
        member.username = name;
        member.age = age;
        member.password = password;
        return member;
    }

    public Member update(String username, String email) {
        this.username = username;
        this.email = email;
        return this;
    }


}
