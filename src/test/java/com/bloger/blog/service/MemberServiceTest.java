package com.bloger.blog.service;

import com.bloger.blog.domain.Member;
import com.bloger.blog.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemoryMemberRepository memberRepository;

    MemberService memberService;


    @AfterEach
    public void afterEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);

        memberRepository.clearStore();
    }
    @Test
    void registerUser() {
        //given
        Member member = new Member();
        member.setName("hello");

        //when
        Long saveId = memberService.join(member);
        //then
        Member findMember = memberService.findOne(saveId).get();

        Assertions.assertThat(member.getName())
                .isEqualTo(findMember.getName());
    }
    @Test
    public void duplicated_register_user_edge() {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        memberService.join(member1);
//        assertThrows(NullPointerException.class, () -> memberService.join(member2));
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        Assertions.assertThat(e.getMessage()).isEqualTo("already exist users.");

//        try {
//            memberService.join(member2);
//            fail();
//
//        } catch (IllegalStateException e) {
//            Assertions.assertThat(e.getMessage()).isEqualTo("already exist users.");
//        }



    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}