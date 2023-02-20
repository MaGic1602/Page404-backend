package com.heaven.heaven.applicationUsers.services;

import com.heaven.heaven.applicationUsers.payload.request.EmailRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UpdateEmailService {
    private final ApplicationUserService applicationUserService;

    public void updateEmail(EmailRequest emailRequest){
        applicationUserService.updateEmail(emailRequest);
    }
}
