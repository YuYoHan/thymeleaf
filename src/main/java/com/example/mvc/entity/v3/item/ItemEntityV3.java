package com.example.mvc.entity.v3.item;

import lombok.*;

import javax.persistence.*;

@Entity(name = "item_v3")
@Table(name = "item_v3")
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemEntityV3 {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long id;

    @Column(nullable = false, length = 50)
    private String itemName;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(nullable = false)
    private int stockNumber;

    @Lob
    @Column(nullable = false)
    private String itemDetail;

    @Enumerated(EnumType.STRING)
    private ItemSellStatus itemSellStatus;

}
