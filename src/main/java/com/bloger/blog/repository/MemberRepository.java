package com.bloger.blog.repository;
import com.bloger.blog.domain.Member;

import java.util.Optional;
import java.util.List;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(long id);
    Optional<Member> findByName(String name);
    Optional<Member> findByMail(String mail);
    List<Member> findAll();
}

