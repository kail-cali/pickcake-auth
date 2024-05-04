package co.pickcake.auth.authdomain.repository;


import co.pickcake.auth.authdomain.entity.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;


@SpringBootTest
@Transactional
class MemberJpaRepositoryTest {

    @Autowired
    private MemberJpaRepository memberRepository;

    @PersistenceContext EntityManager em;

    @Test
    void testGeneric() {
        //given
        Member member1 = Member.create("test1@gmail.com", "test-hail", "test-password");
        memberRepository.save(member1);

        //when
        List<Member> byEmailAndAgeGreaterThan = memberRepository.findByEmailAndAgeGreaterThan("cc@gmail.com", 5);

        //then
        Assertions.assertThat(byEmailAndAgeGreaterThan).isNotNull();
    }

    @Test
    void testFindUser() {
        //given
        Member member = Member.create("test1@gmail.com", "test-hail", "test-password", 10);
        memberRepository.save(member);
        //when
        List<Member> user = memberRepository.findUser("test-hail", 10);
        //then
        Assertions.assertThat(user.getFirst().getId()).isEqualTo(member.getId());
    }


    @Test
    void testFindUserNameList() {
        //given

        Member member1 = Member.create("test1@gmail.com", "test-hail", "test-password", 10);
        Member member2 = Member.create("test2@gmail.com", "test-hail2", "test-password", 30);
        memberRepository.save(member1);
        memberRepository.save(member2);
        //when
        List<String> userNameList = memberRepository.findUserNameList();
        //then
        Assertions.assertThat(userNameList.size()).isEqualTo(2);
    }

    @Test
    void testFindByNames() {
        //given
        Member member1 = Member.create("test1@gmail.com", "test-hail", "test-password", 10);
        Member member2 = Member.create("test2@gmail.com", "test-hail2", "test-password", 30);
        memberRepository.save(member1);
        memberRepository.save(member2);
        //when
        List<Member> byNames = memberRepository.findByUsernames(Arrays.asList("hail", "Cail", "cail"));
        //then
        byNames.forEach(System.out::println);
    }

    @Test
    @DisplayName("벌크 쿼리 ")
    void testBulkQuery() {
        //given
        Member member1 = Member.create("test1@gmail.com", "test-hail", "test-password", 20);
        Member member2 = Member.create("test2@gmail.com", "test-hail2", "test-password", 25);
        Member member3 = Member.create("test3@gmail.com", "test-hail3", "test-password", 22);
        Member member4 = Member.create("test4@gmail.com", "test-hail4", "test-password", 19);
        memberRepository.save(member1);
        memberRepository.save(member2);
        memberRepository.save(member3);
        memberRepository.save(member4);
        //when
        int result = memberRepository.bulkAgePlus(20);
        //then
        Assertions.assertThat(result).isEqualTo(3);
    }

}