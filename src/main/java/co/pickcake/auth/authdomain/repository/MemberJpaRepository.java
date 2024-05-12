package co.pickcake.auth.authdomain.repository;

import co.pickcake.auth.authdomain.entity.Member;
import co.pickcake.auth.authdomain.entity.ProviderType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface MemberJpaRepository extends JpaRepository<Member, Long> {

    List<Member> findByEmailAndAgeGreaterThan(String email, int age);

    @Query("select m from Member m where m.username =:username and m.age = :age")
    List<Member> findUser(@Param("username") String username, @Param("age") int age);

    @Query("select m.username from Member m")
    List<String> findUserNameList();

    @Query("select m from Member m where m.username in :names")
    List<Member> findByUsernames(@Param("names") Collection<String> names);

    @Query("select m from Member m where m.username in :names")
    Slice<Member> findByUsernames(@Param("names") Collection<String> names, Pageable pageable);


    Optional<Member> findByEmailAndProviderType(String email, ProviderType provider);

    @Modifying(clearAutomatically = true)
    @Query("update Member m set m.age = m.age + 1 where m.age >= :age")
    int bulkAgePlus(@Param("age") int age);

}

