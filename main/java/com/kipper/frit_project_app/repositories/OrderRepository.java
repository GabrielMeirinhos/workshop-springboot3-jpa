package com.kipper.frit_project_app.repositories;

import com.kipper.frit_project_app.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
