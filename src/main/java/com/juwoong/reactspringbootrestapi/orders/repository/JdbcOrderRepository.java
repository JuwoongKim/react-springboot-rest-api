package com.juwoong.reactspringbootrestapi.orders.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import com.juwoong.reactspringbootrestapi.orders.model.Orders;

@Component
public class JdbcOrderRepository implements OrderRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public JdbcOrderRepository(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Orders save(Orders order) {

        SqlParameterSource parameterSource = new MapSqlParameterSource()
            .addValue("orderId", order.getOrderId().toString())
            .addValue("userId", order.getUserId().toString())
            .addValue("price", order.getPrice())
            .addValue("createdAt", order.getCreatedAt().toString());

        jdbcTemplate.update("INSERT INTO ORDERS VALUES (:orderId, :userId, :price, :createdAt )",
            parameterSource);


        return findById(order.getOrderId());
    }

    @Override
    public Orders findById(UUID orderId) {
        SqlParameterSource parameterSource = new MapSqlParameterSource().addValue("orderId", orderId.toString());

        RowMapper<Orders> orderRowMapper = orderRowMapper();

        return jdbcTemplate.queryForObject("SELECT * FROM ORDERS WHERE ORDER_ID = :orderId", parameterSource,
            orderRowMapper);
    }

    @Override
    public List<Orders> findByUserId(UUID userId) {
        SqlParameterSource parameterSource = new MapSqlParameterSource().addValue("userId", userId.toString());

        RowMapper<Orders> orderRowMapper = orderRowMapper();

        return jdbcTemplate.query("SELECT * FROM ORDERS WHERE USER_ID = :userId", parameterSource, orderRowMapper);
    }


    private RowMapper<Orders> orderRowMapper() {
        return (rs, rowNum) -> {
            UUID orderId = UUID.fromString(rs.getString("order_id"));
            UUID userId = UUID.fromString(rs.getString("user_id"));
            long price = rs.getLong("price");
            LocalDateTime createdAt = rs.getTimestamp("created_at").toLocalDateTime();

            return new Orders(orderId, userId, price, createdAt);
        };
    }

}