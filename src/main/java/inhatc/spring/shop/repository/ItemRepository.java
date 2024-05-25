package inhatc.spring.shop.repository;

import inhatc.spring.shop.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long>, QuerydslPredicateExecutor<Item> {

    List<Item> findByItemName(String itemName); // selete * from item where itemName ..

    List<Item> findByItemNameOrItemDetail(String itemName, String itemDetail);

    List<Item> findByPriceLessThanOrderByPriceDesc(int price);
    @Query("select i from Item i where i.itemDetail like %:itemDetail% order by i.price desc" )
    List<Item> findByDetail(@Param("itemDetail") String itemDetail); // JPQL

    @Query(value = "select * from Item i where i.item_Detail like %:itemDetail% order by i.price asc", nativeQuery = true )
    List<Item> findByDetailNative(@Param("itemDetail") String itemDetail); // Native
}
