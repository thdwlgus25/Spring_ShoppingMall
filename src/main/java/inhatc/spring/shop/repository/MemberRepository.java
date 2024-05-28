package inhatc.spring.shop.repository;

import inhatc.spring.shop.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    // Optional로 null 처리를 쉽게 하기 위해.
    Optional<Member> findByEmail(String email);
}
