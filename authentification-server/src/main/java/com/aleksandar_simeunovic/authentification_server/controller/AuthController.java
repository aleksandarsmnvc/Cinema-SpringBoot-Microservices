package com.aleksandar_simeunovic.authentification_server.controller;

import com.aleksandar_simeunovic.authentification_server.dto.RegisterDTO;
import com.aleksandar_simeunovic.authentification_server.dto.TokenDTO;
import com.aleksandar_simeunovic.authentification_server.request.LoginRequest;
import com.aleksandar_simeunovic.authentification_server.request.RegisterRequest;
import com.aleksandar_simeunovic.authentification_server.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService service;

    @PostMapping("/login")
    public ResponseEntity<TokenDTO> LoginUser(LoginRequest request){
       return ResponseEntity.ok(service.authentificate(request));
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterDTO> RegisterUser(RegisterRequest request){
       return ResponseEntity.ok((service.register(request)));
    }
}
