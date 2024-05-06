package com.example.mvc.repository.v3.item;

import com.example.mvc.entity.v3.item.ItemEntityV3;
import lombok.extern.log4j.Log4j2;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
@Log4j2
@Transactional
class ItemRepositoryV3Test {

    @Autowired
    ItemRepositoryV3 itemRepositoryV3;

    public void createItemList() {
        for (int i = 1; i < 10; i++) {
            ItemEntityV3 item = ItemEntityV3.builder()
                    .itemName("테스트 상품" + i)
                    .price(10000 + i)
                    .itemDetail("테스트 상품 상세 설명" + i)
                    .stockNumber(100)
                    .build();

            ItemEntityV3 save = itemRepositoryV3.save(item);
        }
    }

    @Test
    @DisplayName("상품 저장 테스트")
    void createItemTest() {
        this.createItemList();
        List<ItemEntityV3> itemList = itemRepositoryV3.findByItemName("테스트 상품1");
        for (ItemEntityV3 item : itemList) {
            log.info(item);
            Assertions.assertThat(item).isNotNull();
        }
    }

    @Test
    @DisplayName("상품명, 상품상세설명 or 테스트")
    void findByItemNameOrItemDetailTest() {
        this.createItemList();
        List<ItemEntityV3> itemList
                = itemRepositoryV3.findByItemNameOrItemDetail(
                        "테스트 상품1", "테스트 상품 상세 설명5");

        for (ItemEntityV3 item : itemList) {
            log.info(item);
            Assertions.assertThat(item).isNotNull();
        }
    }

    @Test
    @DisplayName("가격 LessThan 테스트")
    void findByPriceLessThanTest() {
        this.createItemList();
        List<ItemEntityV3> itemList =
                itemRepositoryV3.findByPriceLessThan(10005);

        for (ItemEntityV3 item : itemList) {
            log.info(item);
        }
    }

    @Test
    @DisplayName("가격 내림차순 조회 테스트")
    void findBiyPriceLessThanOrderByPriceDesc() {
        this.createItemList();
        List<ItemEntityV3> itemList =
                itemRepositoryV3.findByPriceLessThanOrderByPriceDesc(10005);

        for (ItemEntityV3 item : itemList) {
            log.info(item);
        }
    }

    @Test
    @DisplayName("@Query를 이용한 상품 조회 테스트")
    void findByItemDetailTest() {
        this.createItemList();
        List<ItemEntityV3> itemList =
                itemRepositoryV3.findByItemDetail("테스트 상품 상세 설명");

        for (ItemEntityV3 item : itemList) {
            log.info(item);
        }
    }

}