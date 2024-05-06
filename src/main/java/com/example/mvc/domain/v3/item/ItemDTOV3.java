package com.example.mvc.domain.v3.item;

import com.example.mvc.entity.v3.item.ItemSellStatus;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemDTOV3 {
    private Long id;
    private String itemName;
    private int price;
    private int stockNumber;
    private String itemDetail;
    private ItemSellStatus itemSellStatus;
    private LocalDateTime regTime;
    private LocalDateTime updateTime;
}
