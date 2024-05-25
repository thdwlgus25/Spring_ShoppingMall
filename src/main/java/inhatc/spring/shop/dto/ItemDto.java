package inhatc.spring.shop.dto;

import inhatc.spring.shop.constant.ItemSellStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Lob;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemDto {

    private Long id; // 아이디

    private String itemName; // 이름

    private int price; // 가격

    private int stockNumber; // 재고 수량

    private String itemDetail; // 상품 상세 설명

    private String itemSellStatus; // 상품의 판매 상태

    private LocalDateTime registerTime; // 등록 시간

    private LocalDateTime updateTime; // 수정 시간
}
