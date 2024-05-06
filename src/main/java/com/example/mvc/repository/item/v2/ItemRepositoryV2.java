package com.example.mvc.repository.item.v2;

import com.example.mvc.entity.v2.ItemEntityV2;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepositoryV2 extends JpaRepository<ItemEntityV2, Long> {
}
