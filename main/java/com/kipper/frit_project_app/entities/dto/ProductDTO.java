package com.kipper.frit_project_app.entities.dto;

import com.kipper.frit_project_app.entities.Category;
import com.kipper.frit_project_app.entities.Product;

import java.util.Set;
import java.util.stream.Collectors;

public record ProductDTO(
        Long id,
        String name,
        String description,
        Double price,
        String imgUrl,
        Set<String> categories
) {
    public ProductDTO(Product product) {
        this(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getImgUrl(),
                product.getCategories().stream().map(Category::getName).collect(Collectors.toSet())
        );
    }
}
