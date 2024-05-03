package com.example.mvc.repository.item.v1;

import com.example.mvc.domain.v1.ItemSearchCond;
import com.example.mvc.domain.v1.ItemUpdateDTO;
import com.example.mvc.domain.v1.ItemV1;

import java.util.List;
import java.util.Optional;

public interface ItemRepositoryV1 {
    ItemV1 save(ItemV1 item);

    void update(Long itemId, ItemUpdateDTO updateParam);

    Optional<ItemV1> findById(Long id);

    List<ItemV1> findAll(ItemSearchCond cond);
}
