package com.example.demo.registration.token;


import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ConfirmationTokenService {

    private final TokenConfirmationRepository tokenConfirmationRepository;

    public void saveConfirmationToken(ConfirmationToken token) {
        tokenConfirmationRepository.save(token);
    }
    public Optional<ConfirmationToken> getToken(String token){
        return tokenConfirmationRepository.findByToken(token);
    }
    public int setConfirmedAt(String token){
        return tokenConfirmationRepository.updateConfirmedAt(
                token, LocalDateTime.now()
        );
    }
}
