package com.shvk.identity.controller;


import com.shvk.identity.dto.AuthRequest;
import com.shvk.identity.entity.UserCredential;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/register")
    public String addNewUser(@RequestBody UserCredential user) {
        return "Token is valid";
    }

    @PostMapping("/token")
    public String getToken(@RequestBody AuthRequest authRequest) {
        return "Token is valid";
    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token) {
        return "Token is valid";
    }
}
