package com.kipper.frit_project_app.service;

import com.kipper.frit_project_app.entities.Category;
import com.kipper.frit_project_app.entities.User;
import com.kipper.frit_project_app.repositories.CategoryRepository;
import com.kipper.frit_project_app.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> obj = repository.findById(id);
        return obj.get();
    }
}
