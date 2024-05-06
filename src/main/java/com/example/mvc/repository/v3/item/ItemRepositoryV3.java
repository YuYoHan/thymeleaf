package com.example.mvc.repository.v3.item;

import com.example.mvc.entity.v3.item.ItemEntityV3;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepositoryV3 extends JpaRepository<ItemEntityV3, Long> {
    List<ItemEntityV3> findByItemName(String itemName);
}
