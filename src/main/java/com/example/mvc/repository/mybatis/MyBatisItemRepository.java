package com.example.mvc.repository.mybatis;

import com.example.mvc.domain.v1.ItemSearchCond;
import com.example.mvc.domain.v1.ItemUpdateDTO;
import com.example.mvc.domain.v1.ItemV1;
import com.example.mvc.repository.item.v1.ItemRepositoryV1;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Log4j2
@RequiredArgsConstructor
public class MyBatisItemRepository implements ItemRepositoryV1 {
    private final ItemMapper itemMapper;

    @Override
    public ItemV1 save(ItemV1 item) {
        log.info("itemMapper class ={}", itemMapper.getClass() );
        itemMapper.save(item);
        return item;
    }

    @Override
    public void update(Long itemId, ItemUpdateDTO updateParam) {
        itemMapper.update(itemId, updateParam);
    }

    @Override
    public Optional<ItemV1> findById(Long id) {
        return itemMapper.findById(id);
    }

    @Override
    public List<ItemV1> findAll(ItemSearchCond cond) {
        return itemMapper.findAll(cond);
    }
}
