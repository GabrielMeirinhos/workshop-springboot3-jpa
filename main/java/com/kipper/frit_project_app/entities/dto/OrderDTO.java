package com.kipper.frit_project_app.entities.dto;

import com.kipper.frit_project_app.entities.Order;
import com.kipper.frit_project_app.entities.enums.OrderStatus;


import java.time.Instant;
import java.util.List;
import java.util.Set;


public record OrderDTO(
        Long id,
        Instant moment,
        OrderStatus orderStatus,
        String clientName,
        String clientEmail,
        List<OrderItemDTO> items,
        Double total,
        PaymentDTO payment
) {
    public OrderDTO(Order order) {
        this(
                order.getId(),
                order.getMoment(),
                order.getOrderStatus(),
                order.getClient().getName(),
                order.getClient().getEmail(),
                order.getItemsDTO(),
                order.getTotal(),
                order.getPayment() != null ? new PaymentDTO(order.getPayment()) : null
        );
    }
}
