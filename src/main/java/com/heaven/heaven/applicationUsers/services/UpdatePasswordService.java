package com.heaven.heaven.applicationUsers.services;

import com.heaven.heaven.applicationUsers.models.ApplicationUser;
import com.heaven.heaven.applicationUsers.payload.request.PasswordRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdatePasswordService {
    private final ApplicationUserService applicationUserService;

    public  void updatePassword(PasswordRequest passwordRequest, ApplicationUser applicationUser) {
        applicationUserService.updatePassword(passwordRequest, applicationUser);
    }
}
