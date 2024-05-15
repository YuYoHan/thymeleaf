package com.example.mvc.repository.item.v1.jdbctemplate;

import com.example.mvc.domain.v1.ItemSearchCond;
import com.example.mvc.domain.v1.ItemUpdateDTO;
import com.example.mvc.domain.v1.ItemV1;
import com.example.mvc.repository.item.v1.ItemRepositoryV1;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
// JdbcTemplate
public class JdbcTemplateItemRepositoryV1 implements ItemRepositoryV1 {

    private final JdbcTemplate template;

    public JdbcTemplateItemRepositoryV1(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    @Override
    public ItemV1 save(ItemV1 item) {
        String sql = "insert into item(item_name, price, quantity) values(?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        template.update(connection -> {
            // 자동 증가 키
            PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
            ps.setString(1, item.getItemName());
            ps.setInt(2, item.getPrice());
            ps.setInt(3, item.getQuantity());
            return ps;
        }, keyHolder);

        Long key = keyHolder.getKey().longValue();
        item.addId(key);
        return item;
    }

    @Override
    public void update(Long itemId, ItemUpdateDTO updateParam) {
        String sql = "update item set item_name = ?, price=?, quantity=? where id=?";
        template.update(sql,
                updateParam.getItemName(),
                updateParam.getPrice(),
                updateParam.getStockNumber(),
                itemId);
    }

    @Override
    public Optional<ItemV1> findById(Long id) {
        String sql = "select id, item_name, price, quantity from item where id = ?";
        try {
            ItemV1 itemV1 = template.queryForObject(sql, itemRowMapper(), id);
            return Optional.of(itemV1);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    public List<ItemV1> findAll(ItemSearchCond cond) {
        String itemName = cond.getItemName();
        Integer maxPrice = cond.getMaxPrice();

        String sql = "select id, item_name, price, quantity from item";
        //동적 쿼리
        if (StringUtils.hasText(itemName) || maxPrice != null) {
            sql += " where";
        }

        boolean andFlag = false;
        List<Object> param = new ArrayList<>();
        if (StringUtils.hasText(itemName)) {
            sql += " item_name like concat('%',?,'%')";
            param.add(itemName);
            andFlag = true;
        }

        if (maxPrice != null) {
            if (andFlag) {
                sql += " and";
            }
            sql += " price <= ?";
            param.add(maxPrice);
        }

        return template.query(sql, itemRowMapper(), param.toArray());
    }



    private RowMapper<ItemV1> itemRowMapper() {
        return ((rs, rowNum) -> {
            return ItemV1.builder()
                    .id(rs.getLong("id"))
                    .itemName(rs.getString("item_name"))
                    .price(rs.getInt("price"))
                    .quantity(rs.getInt("quantity"))
                    .build();
        });
    }
}
