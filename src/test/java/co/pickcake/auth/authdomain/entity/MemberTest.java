package co.pickcake.auth.authdomain.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
class MemberTest {

    @PersistenceContext
    private EntityManager em;

    @Test
    @DisplayName("데이터 검증")
    @Transactional
    public void testEntity() {
        //given
        Member member1 = Member.create("test1@gmail.com", "test-hail", "test-password", 10);
        Member member2 = Member.create("test2@gmail.com", "test-hail2", "test-password", 30);


        //when
        em.persist(member1);
        em.persist(member2);
        em.flush();
        em.clear();
        //then
         List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();
         Assertions.assertThat(members.size()).isEqualTo(2);

    }

}