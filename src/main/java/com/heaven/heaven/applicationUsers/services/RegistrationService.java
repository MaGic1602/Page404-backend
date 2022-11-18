package com.heaven.heaven.applicationUsers.services;

import com.heaven.heaven.applicationUsers.models.ApplicationUser;
import com.heaven.heaven.applicationUsers.models.ApplicationUserRole;
import com.heaven.heaven.applicationUsers.payload.request.RegistrationRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {
    private final ApplicationUserService applicationUserService;
    public String register(RegistrationRequest request) {
        return applicationUserService.signUpUser(new ApplicationUser(
                request.getUsername(),
                request.getEmail(),
                request.getPassword(),
                ApplicationUserRole.USER

        ));
    }



}
