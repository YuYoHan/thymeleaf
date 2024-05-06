package com.example.mvc.repository.v3.item;

import com.example.mvc.entity.v3.item.ItemEntityV3;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class ItemRepositoryV3Test {

    @Autowired
    ItemRepositoryV3 itemRepositoryV3;

    @Test
    @DisplayName("상품 저장 테스트")
    void createItemTest() {
        ItemEntityV3 item = ItemEntityV3.builder()
                .itemName("테스트 상품")
                .price(10000)
                .itemDetail("테스트 상품 상세 설명")
                .stockNumber(100)
                .build();

        ItemEntityV3 save = itemRepositoryV3.save(item);
        Assertions.assertThat(save).isNotNull();
    }

}