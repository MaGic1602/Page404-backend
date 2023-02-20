package com.heaven.heaven.applicationUsers.controllers;

import com.heaven.heaven.applicationUsers.models.ApplicationUser;
import com.heaven.heaven.applicationUsers.payload.request.EmailRequest;
import com.heaven.heaven.applicationUsers.payload.request.PasswordRequest;
import com.heaven.heaven.applicationUsers.payload.request.RegistrationRequest;
import com.heaven.heaven.applicationUsers.repositories.ApplicationUserRepository;
import com.heaven.heaven.applicationUsers.services.RegistrationService;
import com.heaven.heaven.applicationUsers.services.UpdateEmailService;
import com.heaven.heaven.applicationUsers.services.UpdatePasswordService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping(path="/api")
public class Controller {

    private RegistrationService registrationService;
    private ApplicationUserRepository applicationUserRepository;
    private UpdatePasswordService updatePasswordService;
    private UpdateEmailService updateEmailService;



    @CrossOrigin
    @PostMapping(path = "/register")
    public String register(@RequestBody RegistrationRequest request){
        return registrationService.register(request);
    }

@CrossOrigin
@PostMapping(path="/updatePassword")
public void updatePassword(@RequestBody PasswordRequest passwordRequest, Authentication authentication, ApplicationUser applicationUser){
        updatePasswordService.updatePassword(passwordRequest, applicationUser);

}

    @CrossOrigin
    @PostMapping(path="/updateEmail")
    public void updateEmail(@RequestBody EmailRequest emailRequest){
        updateEmailService.updateEmail(emailRequest);

    }

    @CrossOrigin
    @GetMapping(path = "/users")
    public List<ApplicationUser> getUsers(){
        return applicationUserRepository.findAll();
    }

}
