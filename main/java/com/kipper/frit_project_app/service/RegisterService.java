package com.kipper.frit_project_app.service;

import com.kipper.frit_project_app.entities.user.RegisterDTO;
import com.kipper.frit_project_app.entities.user.User;
import com.kipper.frit_project_app.repositories.UserRepository;
import com.kipper.frit_project_app.service.exception.IllegalArgException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Service
public class RegisterService {

    @Autowired
    private UserRepository repository;

    public User register(@Valid RegisterDTO data) {
            if (data.password().length() < 8) {
                System.out.println("ENTROU AQUIIIIIIIIIIII");
                throw new IllegalArgException();
            }
            String encodedPassword = new BCryptPasswordEncoder().encode(data.password());


            User newUser = new User(data.email(), data.name(), encodedPassword, data.phone(), data.role());

            User user = this.repository.save(newUser);
            return newUser;

    }
}
