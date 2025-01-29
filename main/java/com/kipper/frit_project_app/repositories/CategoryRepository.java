package com.kipper.frit_project_app.repositories;

import com.kipper.frit_project_app.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
