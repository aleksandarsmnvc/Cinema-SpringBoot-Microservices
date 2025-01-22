package com.aleksandar_simeunovic.authentification_server.service;

import com.aleksandar_simeunovic.authentification_server.dto.RegisterDTO;
import com.aleksandar_simeunovic.authentification_server.dto.TokenDTO;
import com.aleksandar_simeunovic.authentification_server.exc.WrongCredentialsException;
import com.aleksandar_simeunovic.authentification_server.request.LoginRequest;
import com.aleksandar_simeunovic.authentification_server.request.RegisterRequest;
import com.aleksandar_simeunovic.authentification_server.client.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtService jwtService;

    public TokenDTO authentificate(LoginRequest request){
        Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
        if(authentication.isAuthenticated()){
            return TokenDTO.builder()
                    .token(jwtService.generateToken(request.getUsername()))
                    .build();
        }
        else throw new WrongCredentialsException("Wrong username or password!");
    }
    public RegisterDTO register(RegisterRequest request){
        return userService.save(request).getBody();
    }
}
