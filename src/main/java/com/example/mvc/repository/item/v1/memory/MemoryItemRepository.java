package com.example.mvc.repository.item.v1.memory;

import com.example.mvc.domain.v1.ItemSearchCond;
import com.example.mvc.domain.v1.ItemUpdateDTO;
import com.example.mvc.domain.v1.ItemV1;
import com.example.mvc.repository.item.v1.ItemRepositoryV1;
import org.springframework.stereotype.Repository;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class MemoryItemRepository implements ItemRepositoryV1 {
    private static final Map<Long, ItemV1> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public ItemV1 save(ItemV1 item) {
        item = ItemV1.builder()
                .id(++sequence)
                .build();
        store.put(item.getId(), item);
        return item;
    }

    @Override
    public void update(Long itemId, ItemUpdateDTO updateParam) {
        ItemV1 findItem = findById(itemId)
                .orElseThrow();
        findItem.update(updateParam);
    }

    @Override
    public Optional<ItemV1> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<ItemV1> findAll(ItemSearchCond cond) {
        String itemName = cond.getItemName();
        Integer maxPrice = cond.getMaxPrice();
        return store.values().stream()
                .filter(item -> {
                    if(ObjectUtils.isEmpty(itemName)) {
                        return true;
                    }
                    return item.getItemName().contains(itemName);
                }).filter(item -> {
                    if(maxPrice == null) {
                        return true;
                    }
                    return item.getPrice() <= maxPrice;
                }).collect(Collectors.toList());
    }

    public void clearStore() {
        store.clear();
    }
}
