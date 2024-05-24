package inhatc.spring.shop.repository;

import inhatc.spring.shop.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByitemName(String itemName); // selete * from item where itemName ..
}
