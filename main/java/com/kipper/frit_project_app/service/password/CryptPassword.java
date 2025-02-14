package com.kipper.frit_project_app.service.password;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CryptPassword {

    public String encodedPassword(String password){
        return new BCryptPasswordEncoder().encode(password);
    }
}
