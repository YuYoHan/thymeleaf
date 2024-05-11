package com.example.mvc.repository.v3.item;

import com.example.mvc.entity.v3.item.ItemEntityV3;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ItemRepositoryV3 extends JpaRepository<ItemEntityV3, Long> {
    List<ItemEntityV3> findByItemName(String itemName);
    List<ItemEntityV3> findByItemNameOrItemDetail(String itemName, String itemDetail);
    // 파라미터로 넘어온 price 변수보다 값이 작은 상품 데이터를 조회
    List<ItemEntityV3> findByPriceLessThan(Integer price);
    List<ItemEntityV3> findByPriceLessThanOrderByPriceDesc(Integer price);

    @Query("select i from item_v3 i where i.itemDetail like " +
            "%:itemDetail% order by i.price desc ")
    List<ItemEntityV3> findByItemDetail(@Param("itemDetail") String itemDetail);

    @Query(value = "select i from item_v3 i where i.itemDetail " +
            "like %:itemDetail% order by i.price desc")
    List<ItemEntityV3> findByItemDetailByNative(@Param("itemDetail") String itemDetail);
}
