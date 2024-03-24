package com.bloger.blog.authdomain.repository;

import com.bloger.blog.authdomain.entity.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }
    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }



    public Optional<Member> find(Long id) {
        Member member = em.find(Member.class, id);
        return Optional.ofNullable(member);
    }
    public Long count() {
        return em.createQuery("select count(m) from Member m", Long.class).getSingleResult();
    }




}
