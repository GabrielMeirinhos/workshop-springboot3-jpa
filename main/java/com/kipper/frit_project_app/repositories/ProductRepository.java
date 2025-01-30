package com.kipper.frit_project_app.repositories;

import com.kipper.frit_project_app.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
