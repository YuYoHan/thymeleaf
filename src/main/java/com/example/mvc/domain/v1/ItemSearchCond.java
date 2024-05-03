package com.example.mvc.domain.v1;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ItemSearchCond {
    private String itemName;
    private Integer maxPrice;

}
