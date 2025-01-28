package com.kipper.frit_project_app.repositories;

import com.kipper.frit_project_app.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
