package com.bloger.blog.service;

import com.bloger.blog.repository.MemberRepository;
import com.bloger.blog.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class MemberServiceIntergrationTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;




}
