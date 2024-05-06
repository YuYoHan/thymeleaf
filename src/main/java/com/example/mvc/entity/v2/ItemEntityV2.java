package com.example.mvc.entity.v2;

import com.example.mvc.domain.v2.ItemDTOV2;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity(name = "item")
@ToString(exclude = "images")
public class ItemEntityV2 {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;
    private String itemName;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UploadFileEntityV2> images = new ArrayList<>();

    @Builder
    public ItemEntityV2(Long id, String itemName, List<UploadFileEntityV2> images) {
        this.id = id;
        this.itemName = itemName;
        this.images = images;
    }

}
