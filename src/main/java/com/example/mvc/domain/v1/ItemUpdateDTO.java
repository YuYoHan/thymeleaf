package com.example.mvc.domain.v1;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Builder
public class ItemUpdateDTO {
    private String itemName;
    private Integer price;
    private Integer quantity;
}
