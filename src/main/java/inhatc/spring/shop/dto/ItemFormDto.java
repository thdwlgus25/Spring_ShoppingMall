package inhatc.spring.shop.dto;

import inhatc.spring.shop.constant.ItemSellStatus;
import inhatc.spring.shop.entity.Item;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemFormDto {

    private Long id; // 아이디

    @NotBlank(message = "상품명은 필수 입력 값입니다.")
    private String itemName; // 이름

    @NotNull(message = "가격은 필수 입력 값입니다.")
    private int price; // 가격

    @NotNull(message = "수량은 필수 입력 값입니다.")
    private int stockNumber; // 재고 수량

    @NotBlank(message = "상품 상세 설명은 필수 입력 값입니다.")
    private String itemDetail; // 상품 상세 설명

    private ItemSellStatus itemSellStatus; // 상품의 판매 상태

    private List<ItemImgDto> itemImgDtoList = new ArrayList<>();

    private List<Long> itemImgIds = new ArrayList<>();

    private static ModelMapper modelMapper = new ModelMapper();

    // dto -> entity
    public Item createItem() {
        Item item = modelMapper.map(this, Item.class);
        return item;
    }

    // entity -> dto
    public static ItemFormDto entityToDto(Item item) {
        ItemFormDto itemFormDto = modelMapper.map(item, ItemFormDto.class);
        return itemFormDto;
    }


}
