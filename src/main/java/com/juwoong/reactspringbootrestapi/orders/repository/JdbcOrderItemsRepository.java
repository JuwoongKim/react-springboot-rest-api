package com.juwoong.reactspringbootrestapi.orders.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.jdbc.core.RowMapper;
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

    @Override
    public List<OrderItems> findByOrderId(UUID orderId) {
        SqlParameterSource parameterSource = new MapSqlParameterSource().addValue("orderId", orderId.toString());

        RowMapper<OrderItems> orderItemsRowMapper = orderItemsRowMapper();

        return jdbcTemplate.query("SELECT * FROM ORDER_ITEMS WHERE ORDER_ID = :orderId", parameterSource,
            orderItemsRowMapper);
    }

    private RowMapper<OrderItems> orderItemsRowMapper() {
        return (rs, rowNum) -> {
            UUID orderItemId = UUID.fromString(rs.getString("order_item_id"));
            UUID orderId = UUID.fromString(rs.getString("order_id"));
            UUID contentId = UUID.fromString(rs.getString("content_id"));
            String contentTitle = rs.getString("content_title");
            long price = rs.getLong("price");

            return new OrderItems(orderItemId, orderId, contentId, contentTitle, price);
        };
    }

}
