package com.kipper.frit_project_app.service;

import com.kipper.frit_project_app.entities.user.User;
import com.kipper.frit_project_app.entities.user.UserDTO;
import com.kipper.frit_project_app.repositories.UserRepository;
import com.kipper.frit_project_app.service.exception.DatabaseException;
import com.kipper.frit_project_app.service.exception.HttpMessageNotReadableException;
import com.kipper.frit_project_app.service.exception.HttpRequestMethodNotSupportedException;
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

    public List<UserDTO> findAll() {
         return repository.findAll().stream().map(
                user -> new UserDTO(user)).toList();
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
                if(id == null || id <= 0) {
                    throw new HttpMessageNotReadableException(id.toString());
                }
                else if (!repository.existsById(id)) {
                    throw new ResourceNotFoundException(id);
                }
                repository.deleteById(id);
            }catch (EmptyResultDataAccessException e){
                 throw new ResourceNotFoundException(id);
            }
            catch (DataIntegrityViolationException e){
                throw new DatabaseException(e.toString());
            }catch (HttpRequestMethodNotSupportedException e){
                throw new HttpMessageNotReadableException(e.toString());
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
    }//TODO: se o cara não passar nada

    private void updateData(User entity, User user) {
        entity.setName(user.getName());
        Optional<User> obj = Optional.ofNullable(repository.findByEmail(user.getEmail()));
        if(obj.isPresent()) {
            throw new RuntimeException();
        }
            entity.setEmail(user.getEmail());
        entity.setPhone(user.getPhone());
    }
}
