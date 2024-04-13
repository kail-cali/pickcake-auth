package co.pickcake.auth.authdomain.repository;

import co.pickcake.auth.authdomain.entity.Team;
import co.pickcake.auth.authdomain.dto.MemberDto;
import co.pickcake.auth.authdomain.entity.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;


@SpringBootTest
class MemberJpaRepositoryTest {

    @Autowired
    private MemberJpaRepository memberRepository;

    @Autowired
    private TeamJpaRepository teamRepository;

    @Test
    void testGeneric() {
        //given
//        Team teamA = new Team("teamA");

        Member member = new Member("cc@gmail.com", "hail", 10, null);
        memberRepository.save(member);

        //when
        List<Member> byEmailAndAgeGreaterThan = memberRepository.findByEmailAndAgeGreaterThan("cc@gmail.com", 5);

        //then
        Assertions.assertThat(byEmailAndAgeGreaterThan).isNotNull();
    }

    @Test
    void testFindUser() {
        //given
        Member member = new Member("cc@gmail.com", "hail", 10, null);
        memberRepository.save(member);
        //when
        List<Member> user = memberRepository.findUser("hail", 10);
        //then
        Assertions.assertThat(user.getFirst().getId()).isEqualTo(member.getId());
    }


    @Test
    void testFindUserNameList() {
        //given
        Member member1 = new Member("cc@gmail.com", "hail", 10, null);
        Member member2 = new Member("cccc@gmail.com", "cali", 30, null);
        memberRepository.save(member1);
        memberRepository.save(member2);
        //when
        List<String> userNameList = memberRepository.findUserNameList();
        //then
        Assertions.assertThat(userNameList.size()).isEqualTo(2);
    }

    @Test
    void testMemberByString() {
        //given
        Team team = new Team("teamA");
        teamRepository.save(team);
        Member member1 = new Member("cc@gmail.com", "hail", 10, null);
        Member member2 = new Member("cccc@gmail.com", "cali", 30, null);

        memberRepository.save(member1);
        memberRepository.save(member2);
        member1.changeTeam(team);
        member2.changeTeam(team);

        //when
//        List<MemberDto> memberDto = memberRepository.findMemberDto();
        List<String > memberDto = memberRepository.findUserNameList();
        //then
        memberDto.forEach(System.out::println);
    }

    @Test
    void testMemberDtoList() {
        //given
        Team team = new Team("teamA");
        teamRepository.save(team);
        Member member1 = new Member("cc@gmail.com", "hail", 10, team);
        Member member2 = new Member("cccc@gmail.com", "cali", 30, team);
        memberRepository.save(member1);
        memberRepository.save(member2);
        //when
        List<MemberDto> memberDto = memberRepository.findMemberDto();
        //then
        memberDto.forEach(System.out::println);
    }

    @Test
    void testFindByNames() {
        //given
        Team team = new Team("teamA");
        teamRepository.save(team);
        Member member1 = new Member("cc@gmail.com", "hail", 10, team);
        Member member2 = new Member("cccc@gmail.com", "cali", 30, team);
        memberRepository.save(member1);
        memberRepository.save(member2);
        //when
        List<Member> byNames = memberRepository.findByNames(Arrays.asList("hail", "Cail", "cail"));
        //then
        byNames.forEach(System.out::println);
    }


}