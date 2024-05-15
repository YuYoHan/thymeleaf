package com.example.mvc.repository.mybatis;

import com.example.mvc.domain.v1.ItemSearchCond;
import com.example.mvc.domain.v1.ItemUpdateDTO;
import com.example.mvc.domain.v1.ItemV1;
import com.example.mvc.entity.v3.item.ItemEntityV3;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ItemMapper {
    void save(ItemV1 item);
    void update(@Param("id") Long id, @Param("updateParam")ItemUpdateDTO updateDTO);
    Optional<ItemV1> findById(Long id);
    List<ItemV1> findAll(ItemSearchCond itemSearch);
}
