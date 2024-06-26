package inhatc.spring.shop.service;

import inhatc.spring.shop.dto.MemberFormDto;
import inhatc.spring.shop.entity.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    // Test할 때는 Autowired를 써야함
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MemberService memberService;


    /**
     * 회원가입 테스트
     */
    public Member createMember() {
        MemberFormDto dto = MemberFormDto.builder()
                .address("인천시 미추홀구")
                .email("test@test.com")
                .password("1111")
                .name("홍길동")
                .build();

        Member member = Member.createMember(dto, passwordEncoder);
        return member;
    }

    @Test
    void saveMemberTest() {
        Member member = createMember();
        System.out.println(member);
        Member member1 = memberService.saveMember(member);
        System.out.println(member1);
    }

    @Test
    @DisplayName("중복 회원 예외 발생 테스트")
    void saveMemberTest2() {
        Member member1 = createMember();
        Member member2 = createMember();
        memberService.saveMember(member1);

        Throwable e = Assertions.assertThrows(IllegalStateException.class, () -> {
                    memberService.saveMember(member2);
        });

        Assertions.assertEquals("이미 존재하는 회원입니다.", e.getMessage());
    }
}