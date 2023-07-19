package com.juwoong.reactspringbootrestapi.orders.repository;

import java.util.List;

import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import com.juwoong.reactspringbootrestapi.orders.model.OrderItems;

@Component
public class JdbcOrderItemsRepository implements OrderItemsRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public JdbcOrderItemsRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveOrderItems(List<OrderItems> orderItemsList) {

        SqlParameterSource[] batchParams = new SqlParameterSource[orderItemsList.size()];

        for (int i = 0; i < orderItemsList.size(); i++) {
            OrderItems orderItem = orderItemsList.get(i);
            MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("orderItemId", orderItem.getOrderItemId().toString())
                .addValue("orderId", orderItem.getOrderId().toString())
                .addValue("contentId", orderItem.getContentId().toString())
                .addValue("contentTitle", orderItem.getContentTitle())
                .addValue("price", orderItem.getPrice());
            batchParams[i] = params;
        }

        jdbcTemplate.batchUpdate(
            "INSERT INTO order_items (order_item_id, order_id, content_id, content_title, price) VALUES (:orderItemId, :orderId, :contentId, :contentTitle, :price)",
            batchParams);

    }
}
