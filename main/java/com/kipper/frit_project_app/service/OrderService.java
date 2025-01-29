package com.kipper.frit_project_app.service;

import com.kipper.frit_project_app.entities.Order;
import com.kipper.frit_project_app.repositories.OrderRepository;
import com.kipper.frit_project_app.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> obj = repository.findById(id);
        return obj.get();
    }
}
