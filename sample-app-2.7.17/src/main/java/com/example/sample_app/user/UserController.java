package com.example.sample_app.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private UserService service;

    public UserController (UserService service) {
        this.service = service;
    }

    @GetMapping("/api/user/{id}")
    public UserDTO getById(@PathVariable long id) throws Exception {
        return service.findById(id);
    }

}
