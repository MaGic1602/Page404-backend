package com.heaven.heaven.applicationUsers.controllers;

import com.heaven.heaven.applicationUsers.models.ApplicationUser;
import com.heaven.heaven.applicationUsers.repositories.ApplicationUserRepository;
import com.heaven.heaven.applicationUsers.payload.request.RegistrationRequest;
import com.heaven.heaven.applicationUsers.services.RegistrationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import static java.util.Arrays.stream;

@RestController
@AllArgsConstructor
@RequestMapping(path="api")
public class Controller {

    private RegistrationService registrationService;
    private ApplicationUserRepository applicationUserRepository;

    @CrossOrigin
    @PostMapping(path = "/register")
    public String Register(@RequestBody RegistrationRequest request){

        return registrationService.register(request);
    }

    @CrossOrigin
    @GetMapping(path = "/users")
    public List<ApplicationUser> getUsers(){
        return applicationUserRepository.findAll();
    }

}
