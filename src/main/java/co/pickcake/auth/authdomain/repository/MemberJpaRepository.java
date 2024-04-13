package co.pickcake.auth.authdomain.repository;

import co.pickcake.auth.authdomain.dto.MemberDto;
import co.pickcake.auth.authdomain.entity.Member;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {

    List<Member> findByEmailAndAgeGreaterThan(String email, int age);
    @Query("select m from Member m where m.name =:username and m.age = :age")
    List<Member> findUser(@Param("username") String username, @Param("age") int age);
    @Query("select m.name from Member m")
    List<String> findUserNameList();
    @Query("select new co.pickcake.auth.authdomain.dto.MemberDto(m.id, m.name, t.teamName) from Member m join m.team t")
    List<MemberDto> findMemberDto();
    @Query("select m from Member m where m.name in :names")
    List<Member> findByNames(@Param("names") Collection<String> names);

    @Query("select m from Member m where m.name in :names")
    Slice<Member> findByNames(@Param("names") Collection<String> names, Pageable pageable);

    



}

