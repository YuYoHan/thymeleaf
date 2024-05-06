package com.example.mvc.domain.v2;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
public class RequestItemDTOV2 {
    private String itemName;

    @Builder
    public RequestItemDTOV2(String itemName) {
        this.itemName = itemName;
    }
}
