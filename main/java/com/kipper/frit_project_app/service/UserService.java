package com.kipper.frit_project_app.service;

import com.kipper.frit_project_app.entities.user.User;
import com.kipper.frit_project_app.entities.user.UserDTO;
import com.kipper.frit_project_app.repositories.UserRepository;
import com.kipper.frit_project_app.service.exception.DatabaseException;
import com.kipper.frit_project_app.service.exception.HttpMessageNotReadableException;
import com.kipper.frit_project_app.service.exception.ResourceNotFoundException;
import com.kipper.frit_project_app.service.exception.databsase_consts.ErrorConsts;
import com.kipper.frit_project_app.service.password.CryptPassword;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private final UserRepository repository;

    @Autowired
    private CryptPassword cryptPassword;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<UserDTO> findAll() {
         return repository.findAll().stream().map(
                 UserDTO::new).toList();
    }

    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));

    }

    public void deleteById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException(ErrorConsts.HTTP_ID_IS_EMPITY.getErr());
        }

        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException(id);
        }

        repository.deleteById(id);
    }

    public User update(Long id, User user) {

            User entity = repository.getReferenceById(id);
        if(user == null){
            return entity;
        }
        try {
            updateData(entity, user);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User entity, User user) {
        if (user.getEmail() != null && !user.getEmail().isEmpty()) {
            User existingEmail = repository.findByEmail(user.getEmail());
            if (existingEmail != null && !existingEmail.getId().equals(entity.getId())) {
                throw new DatabaseException(ErrorConsts.REPEATED_DATA_MAIL.getErr());
            }
        }
        if (user.getPhone() != null && !user.getPhone().isEmpty()) {
            User existingPhone = repository.findByPhone(user.getPhone());
            if (existingPhone != null && !existingPhone.getId().equals(entity.getId())) {
                throw new DatabaseException(ErrorConsts.REPEATED_DATA_PHONE.getErr());
            }
        }

        entity.setName(Objects.nonNull(user.getName()) && !user.getName().isBlank()
                ? user.getName()
                : entity.getName()
        );

        entity.setEmail(Objects.nonNull(user.getEmail()) && !user.getEmail().isBlank()
                ? user.getEmail()
                : entity.getEmail()
        );

        entity.setPhone(Objects.nonNull(user.getPhone()) && !user.getPhone().isBlank()
                ? user.getPhone()
                : entity.getPhone()
        );

        entity.setPassword(Objects.nonNull(user.getPhone()) && !user.getPhone().isBlank()
                ? cryptPassword.encodedPassword(user.getPassword())
                : entity.getPassword()
       );
    }
}