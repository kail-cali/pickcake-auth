package com.bloger.blog.authdomain.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberTest {

    @PersistenceContext
    private EntityManager em;

    @Test
    @DisplayName("유저 엔티티 jpa 테스트")
    @Transactional
    public void testEntity() {
        //given
        Team teamA = new Team("TeamA");
        Team teamB = new Team("TeamB");
        em.persist(teamA);
        em.persist(teamB);
        Member memberA = new Member("hail1@gamil.com", "hail1", 20,teamA);
        Member memberB = new Member("hail2@gamil.com", "hail2",20 ,teamA);
        Member memberC = new Member("hail3@gamil.com", "hail3", 25,teamB);

        //when
        em.persist(memberA);
        em.persist(memberB);
        em.persist(memberC);
        em.flush();
        em.clear();
        //then
         List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();

         for ( Member member : members) {
             System.out.println("member = " + member);
             System.out.println("member.getTeam() = " + member.getTeam());
         }

    }

}