package com.example.mvc;

import com.example.mvc.domain.v1.ItemV1;
import com.example.mvc.repository.item.v1.ItemRepositoryV1;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@Slf4j
@RequiredArgsConstructor
public class TestDataInit {

    private final ItemRepositoryV1 itemRepository;

    /**
     * 확인용 초기 데이터 추가
     */
    @EventListener(ApplicationReadyEvent.class)
    public void initData() {
        log.info("test data init");
        itemRepository.save(ItemV1.builder()
                        .itemName("itemA")
                        .price(10000)
                        .quantity(10)
                .build());
        itemRepository.save(ItemV1.builder()
                        .itemName("itemB")
                        .price(20000)
                        .quantity(20)
                .build());
    }

}
