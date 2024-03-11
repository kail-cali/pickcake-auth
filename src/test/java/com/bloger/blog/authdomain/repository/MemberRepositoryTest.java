package com.bloger.blog.authdomain.repository;

import com.bloger.blog.authdomain.entity.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {


    @Autowired private MemberJpaRepository memberRepository;

    @BeforeEach
    void setUp() {
    }
    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("회원 가입 jpa 테스트")
    @Transactional
    void save() {
        //given
        Member member = Member.create("hail@gamil.com", "hail");
        //when
        memberRepository.save(member);
        Optional<Member> member1 = memberRepository.findById(member.getId());
        //then
        Assertions.assertThat(member1.get().getId()).isEqualTo(member.getId());
    }

    @Test
    void find() {
    }
}