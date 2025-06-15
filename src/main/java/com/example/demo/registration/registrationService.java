package com.example.demo.registration;

import com.example.demo.AppUser.AppUser;
import com.example.demo.AppUser.AppUserRole;
import com.example.demo.AppUser.AppUserService;
import org.springframework.stereotype.Service;

@Service
public class registrationService {
    private final AppUserService appUserService;
    private final EmailValidator emailValidator;

    public registrationService(AppUserService appUserService, EmailValidator emailValidator) {
        this.appUserService = appUserService;
        this.emailValidator = emailValidator;
    }

    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if(!isValidEmail) {
            throw new IllegalArgumentException("Invalid email address");
        }
        return appUserService.signUpUser(
                new AppUser(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getEmail(),
                        request.getPassword(),
                        AppUserRole.USER
                )
        );
    }

}
