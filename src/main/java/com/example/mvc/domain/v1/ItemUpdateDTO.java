package com.example.mvc.domain.v1;

import com.example.mvc.entity.v3.item.ItemSellStatus;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Builder
public class ItemUpdateDTO {
    private String itemName;
    private int price;
    private int stockNumber;
    private String itemDetail;
    private ItemSellStatus itemSellStatus;
}
