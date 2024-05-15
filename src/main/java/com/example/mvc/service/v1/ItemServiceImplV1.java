package com.example.mvc.service.v1;

import com.example.mvc.domain.v1.ItemSearchCond;
import com.example.mvc.domain.v1.ItemUpdateDTO;
import com.example.mvc.domain.v1.ItemV1;
import com.example.mvc.repository.item.v1.ItemRepositoryV1;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemServiceImplV1 implements ItemServiceV1{
    @Qualifier("itemRepositoryV1")
    private final ItemRepositoryV1 itemRepository;

    @Override
    public ItemV1 save(ItemV1 item) {
        return itemRepository.save(item);
    }

    @Override
    public void update(Long itemId, ItemUpdateDTO updateParam) {
        itemRepository.update(itemId, updateParam);
    }

    @Override
    public Optional<ItemV1> findById(Long id) {
        return itemRepository.findById(id);
    }

    @Override
    public List<ItemV1> findItems(ItemSearchCond cond) {
        return itemRepository.findAll(cond);
    }
}
