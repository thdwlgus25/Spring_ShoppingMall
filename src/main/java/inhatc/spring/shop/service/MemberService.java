package inhatc.spring.shop.service;

import inhatc.spring.shop.entity.Member;
import inhatc.spring.shop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor // Autowired를 붙이지 않으면 final을 붙여 객체를 생성할 수 있도록 함
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * 회원가입
     */
    public Member saveMember(Member member) {
        validateDuplicationMember(member); // 기존에 등록된 회원인가?
        return memberRepository.save(member);
    }

    /**
     * 회원 중복 검사
     */
    private void validateDuplicationMember(Member member) {
        Optional<Member> findMember = memberRepository.findByEmail(member.getEmail());
        if(findMember.isPresent()) {
            System.out.println(findMember.get().getName());
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }
}
