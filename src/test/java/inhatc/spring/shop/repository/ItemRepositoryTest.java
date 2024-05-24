package inhatc.spring.shop.repository;

import inhatc.spring.shop.constant.ItemSellStatus;
import inhatc.spring.shop.entity.Item;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional // 남아있던 데이터를 지움
class ItemRepositoryTest {

    @Autowired
    private ItemRepository itemRepository;

    public void createItemList() {
        for (int i = 1; i <= 10; i++) {
            Item item = Item.builder()
                    .itemName("테스트 상품" + i)
                    .price(10000 + i)
                    .stockNumber(100 + i)
                    .itemDetail("테스트 상품 상세 설명" + i)
                    .itemSellStatus(ItemSellStatus.SELL)
                    .registerTime(LocalDateTime.now())
                    .updateTime(LocalDateTime.now())
                    .build(); // 기본 생성자 만든거랑 똑같음

            itemRepository.save(item);
        }
    }
    @Test
    @DisplayName("상품 이름 검색 테스트")
    public void findByItemNameTest() {
        createItemList();

        itemRepository
                .findByitemName("테스트 상품1").
                forEach((item) -> {
                    System.out.println(item);
                });
    }
    @Test
    @DisplayName("상품 생성 테스트") // 임의로 주고싶은 내용으로 테스트를 할 수 있음
    public void createItemTest(){
        Item item = Item.builder()
                .itemName("테스트 상품")
                .price(10000)
                .stockNumber(100)
                .itemDetail("테스트 상품 상세 설명")
                .itemSellStatus(ItemSellStatus.SELL)
                .registerTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build(); // 기본 생성자 만든거랑 똑같음

        System.out.println("item : " + item);
        Item savedItem = itemRepository.save(item);
        System.out.println("sevedItem : " + savedItem);
    }

}