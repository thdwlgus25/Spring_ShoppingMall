package inhatc.spring.shop.entity;

import inhatc.spring.shop.constant.Role;
import inhatc.spring.shop.dto.MemberFormDto;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id; // 아이디

    private String name;

    @Column(unique = true) // 등록할 때 중복이 안 되도록 제약을 걺
    private String email;
    private String password;
    private String address;

    // 스프링 시큐리티에서 꼭 필요한 정보임 (페이지의 대한 접근)
    @Enumerated(EnumType.STRING) // ORDINAL(숫자로 다루는 것) STRING(글자로 다루는 것)
    private Role role;

    // Dto -> Entity
    public static Member createMember(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder) {
        Member member = Member.builder()
                .role(Role.USER)
                .email(memberFormDto.getEmail())
                .address(memberFormDto.getAddress())
                .name(memberFormDto.getName())
                .password(memberFormDto.getPassword())
                .build();

        String password = memberFormDto.getPassword();
        password = passwordEncoder.encode(password);
        member.setPassword(password);

        return member;

    }
}
