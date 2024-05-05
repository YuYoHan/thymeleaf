package com.example.mvc.config.jdbc;

import com.example.mvc.repository.item.v1.ItemRepositoryV1;
import com.example.mvc.repository.item.v1.jdbctemplate.JdbcTemplateItemRepositoryV1;
import com.example.mvc.service.v1.ItemServiceImplV1;
import com.example.mvc.service.v1.ItemServiceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class JdbcTemplateV1Config {
    private final DataSource dataSource;

    @Bean
    public ItemServiceV1 itemServiceV1() {
        return new ItemServiceImplV1(itemRepositoryV1());
    }

    @Bean
    public ItemRepositoryV1 itemRepositoryV1() {
        return new JdbcTemplateItemRepositoryV1(dataSource);
    }
}
