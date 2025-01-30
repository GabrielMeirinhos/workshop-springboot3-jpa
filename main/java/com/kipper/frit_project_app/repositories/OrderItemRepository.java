package com.kipper.frit_project_app.repositories;

import com.kipper.frit_project_app.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
