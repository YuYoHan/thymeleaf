package com.example.mvc.service;

import com.example.mvc.domain.v1.ItemSearchCond;
import com.example.mvc.domain.v1.ItemUpdateDTO;
import com.example.mvc.domain.v1.ItemV1;

import java.util.List;
import java.util.Optional;

public interface ItemServiceV1 {

    ItemV1 save(ItemV1 item);

    void update(Long itemId, ItemUpdateDTO updateParam);

    Optional<ItemV1> findById(Long id);

    List<ItemV1> findItems(ItemSearchCond itemSearch);
}
