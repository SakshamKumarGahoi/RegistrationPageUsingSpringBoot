package com.example.demo.registration.token;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {

    private final TokenConfirmationRepository tokenConfirmationRepository;

    public void saveConfirmationToken(ConfirmationToken token) {
        tokenConfirmationRepository.save(token);
    }
}
