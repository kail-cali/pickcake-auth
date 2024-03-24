package com.bloger.blog.authdomain.repository;

import com.bloger.blog.authdomain.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {

}
