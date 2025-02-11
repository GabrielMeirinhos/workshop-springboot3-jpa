package com.kipper.frit_project_app.entities.dto;

import com.kipper.frit_project_app.entities.OrderItem;

public record OrderItemDTO(
        Long productId,
        String productName,
        Double productPrice,
        Integer quantity,
        Double subTotal
) {
    public OrderItemDTO(OrderItem item) {
        this(
                item.getProduct().getId(),
                item.getProduct().getName(),
                item.getProduct().getPrice(),
                item.getQuantity(),
                item.getSubTotal()
        );
    }
}
