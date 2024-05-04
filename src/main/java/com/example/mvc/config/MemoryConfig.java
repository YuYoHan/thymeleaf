package com.example.mvc.config;

import com.example.mvc.repository.item.v1.ItemRepositoryV1;
import com.example.mvc.repository.item.v1.memory.MemoryItemRepository;
import com.example.mvc.service.ItemServiceImplV1;
import com.example.mvc.service.ItemServiceV1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MemoryConfig {
    @Bean
    public ItemServiceV1 itemServiceV1() {
        return new ItemServiceImplV1(itemRepositoryV1());
    }

    @Bean
    public ItemRepositoryV1 itemRepositoryV1() {
        return new MemoryItemRepository();
    }
}
