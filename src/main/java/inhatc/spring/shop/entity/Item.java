package inhatc.spring.shop.entity;

import inhatc.spring.shop.common.entity.BaseEntity;
import inhatc.spring.shop.constant.ItemSellStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id; // 아이디

    @Column(nullable = false, length = 50)
    private String itemName; // 이름

    private int price; // 가격

    private int stockNumber; // 재고 수량

    @Lob // 큰 자료형을 관리할 수 있음
    @Column(nullable = false)
    private String itemDetail; // 상품 상세 설명

    @Enumerated(EnumType.STRING)
    private ItemSellStatus itemSellStatus; // 상품의 판매 상태


}
