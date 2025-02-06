package com.kipper.frit_project_app.service;

import com.kipper.frit_project_app.entities.user.RegisterDTO;
import com.kipper.frit_project_app.entities.user.User;
import com.kipper.frit_project_app.repositories.UserRepository;
import com.kipper.frit_project_app.service.exception.DatabaseException;
import com.kipper.frit_project_app.service.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));

    }

//    public User insert(User user) {
//        if (user.getPassword().length() < 8) {
//            throw new IllegalArgumentException();
//        }
//        return repository.save(user);
//    }


    public void deleteById(Long id) {
            try{
                if (!repository.existsById(id)) {
                throw new ResourceNotFoundException(id);
                }
                repository.deleteById(id);
            }catch (EmptyResultDataAccessException e){
                 throw new ResourceNotFoundException(id);
            }catch (DataIntegrityViolationException e){
                throw new DatabaseException(e.toString());
            }
    }

    public User update(Long id, User user) {
        try {
            User entity = repository.getReferenceById(id);
            updateData(entity, user);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User entity, User user) {
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
    }
}
