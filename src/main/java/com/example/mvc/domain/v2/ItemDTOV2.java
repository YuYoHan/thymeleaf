package com.example.mvc.domain.v2;

import com.example.mvc.entity.v2.ItemEntityV2;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@ToString
@NoArgsConstructor
public class ItemDTOV2 {
    private Long id;
    private String itemName;
    private List<UploadFileDTOV2> images = new ArrayList<>();

    @Builder
    public ItemDTOV2(Long id, String itemName, List<UploadFileDTOV2> images) {
        this.id = id;
        this.itemName = itemName;
        this.images = images;
    }

    public static ItemDTOV2 changeDTO(ItemEntityV2 item) {
        List<UploadFileDTOV2> images = item.getImages().stream()
                .map(UploadFileDTOV2::changeDTO)
                .collect(Collectors.toList());

        return ItemDTOV2.builder()
                .id(item.getId())
                .itemName(item.getItemName())
                .images(images)
                .build();
    }
}
