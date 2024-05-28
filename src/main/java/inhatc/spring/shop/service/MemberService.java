package inhatc.spring.shop.service;

import inhatc.spring.shop.entity.Member;
import inhatc.spring.shop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor // Autowired를 붙이지 않으면 final을 붙여 객체를 생성할 수 있도록 함
@Slf4j
public class MemberService implements UserDetailsService {

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


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        // 원래는 Optional이 리턴 타입인데, orElseThrow을 하면 .. 상관 X
        Member member = memberRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("해당 사용자가 없습니다." + email));

        log.info("-----> [로그인 사용자]" + member);

        // 이 3가지가 무조건 필요함 (이름(아이디), 비번, 역할)
        return User.builder()
                .username(member.getEmail()) // 우리는 이메일을 이름 대신 쓰고 있음.
                .password(member.getPassword())
                .roles(member.getRole().toString())
                .build();
    }
}
