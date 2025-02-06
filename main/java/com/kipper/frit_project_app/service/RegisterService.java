package com.kipper.frit_project_app.service;

import com.kipper.frit_project_app.entities.user.RegisterDTO;
import com.kipper.frit_project_app.entities.user.User;
import com.kipper.frit_project_app.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "/register")
public class RegisterService {

    @Autowired
    private UserRepository repository;

    public ResponseEntity register(@Valid RegisterDTO data) {
        if (data.password().length() < 8) {
            throw new IllegalArgumentException();
        }
        String encodedPassword = new BCryptPasswordEncoder().encode(data.password());


        User newUser = new User(data.email(),data.name(), encodedPassword,  data.phone(), data.role());

        this.repository.save(newUser);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(data.id()).toUri();
        return ResponseEntity.created(uri).body(data);
    }
}
