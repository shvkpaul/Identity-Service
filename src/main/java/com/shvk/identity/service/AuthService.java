package com.shvk.identity.service;

import com.shvk.identity.dto.RegisterUserRequest;
import com.shvk.identity.entity.UserCredential;
import com.shvk.identity.repository.UserCredentialRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private UserCredentialRepository repository;
    private PasswordEncoder passwordEncoder;
    private JwtService jwtService;

    public AuthService(UserCredentialRepository repository, PasswordEncoder passwordEncoder, JwtService jwtService) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public String saveUser(RegisterUserRequest userRequest) {
        UserCredential credential = new UserCredential();

        credential.setName(userRequest.getUsername());
        credential.setEmail(userRequest.getEmailId());
        credential.setPassword(passwordEncoder.encode(userRequest.getPassword()));

        credential = repository.save(credential);
        return "user added to the system with user id: " + credential.getId();
    }

    public String generateToken(String username) {
        return jwtService.generateToken(username);
    }

    public void validateToken(String token) {
        jwtService.validateToken(token);
    }


}
