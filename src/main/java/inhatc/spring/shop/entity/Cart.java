package inhatc.spring.shop.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cart_id")
    private Long id; // 아이디

    // Member 자체를 가져옴
    @OneToOne
    @JoinColumn(name = "member_id")
    private Member member;
}
