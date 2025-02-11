package com.kipper.frit_project_app.resources;

import com.kipper.frit_project_app.entities.user.User;
import com.kipper.frit_project_app.entities.user.UserDTO;
import com.kipper.frit_project_app.service.UserService;
import com.kipper.frit_project_app.service.exception.HttpRequestMethodNotSupportedException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<UserDTO> list = userService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User obj = userService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

//    @PostMapping
//    public ResponseEntity<User> insert(@RequestBody @Valid User user) {
//        user = userService.insert(user);
//        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
//        return ResponseEntity.created(uri).body(user);
//    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        System.out.println(id + "aqui está o id");
        try{
        userService.deleteById(id);
        return ResponseEntity.noContent().build();

        }catch (HttpRequestMethodNotSupportedException e){
            throw new HttpRequestMethodNotSupportedException(e.toString());
        }
    }

   @PutMapping(value = "/{id}")
    public ResponseEntity<User> update(@PathVariable Long id,@RequestBody User user) {
        user = userService.update(id, user);
        return ResponseEntity.ok().body(user);
   }
   //TODO: Swaggee
}
