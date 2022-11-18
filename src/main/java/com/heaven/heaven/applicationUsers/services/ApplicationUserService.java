package com.heaven.heaven.applicationUsers.services;

import com.heaven.heaven.applicationUsers.models.ApplicationUser;
import com.heaven.heaven.applicationUsers.repositories.ApplicationUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class ApplicationUserService implements UserDetailsService {
private final ApplicationUserRepository applicationUserRepository;
private final BCryptPasswordEncoder bCryptPasswordEncoder;
private final static String USER_NOT_FOUND="User with username %s not found";
private final static String USER_ALREADY_EXISTS="Username already exists";

   @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return applicationUserRepository.findByUsername(username)
                .orElseThrow(()->
                        new UsernameNotFoundException(
                                String.format(USER_NOT_FOUND, username)));
    }

    public String signUpUser(ApplicationUser applicationUser){
        boolean userExists=applicationUserRepository.
                findByUsername(applicationUser.getUsername())
                .isPresent();
        if(userExists){
            throw new IllegalStateException(String.format(USER_ALREADY_EXISTS));}
        String hashedPassword= bCryptPasswordEncoder.encode(applicationUser.getPassword());
        applicationUser.setPassword(hashedPassword);
        applicationUserRepository.save(applicationUser);
        return applicationUser.getUsername();

    }


}
