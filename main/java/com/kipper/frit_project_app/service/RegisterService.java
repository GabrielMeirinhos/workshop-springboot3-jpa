package com.kipper.frit_project_app.service;

import com.kipper.frit_project_app.entities.user.RegisterDTO;
import com.kipper.frit_project_app.entities.user.User;
import com.kipper.frit_project_app.repositories.UserRepository;
import com.kipper.frit_project_app.service.exception.IllegalArgException;
import com.kipper.frit_project_app.service.password.CryptPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private CryptPassword cryptPassword;

    public User register(RegisterDTO data) {
            if (data.password().length() < 8) {
                throw new IllegalArgException();
            }

            String encodedPassword = cryptPassword.encodedPassword(data.password());

            User newUser = new User(data.email(), data.name(), encodedPassword, data.phone(), data.role());


            return this.repository.save(newUser);
    }
}

