package com.aleksandar_simeunovic.authentification_server.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RegisterRequest {
    @NotBlank
    private final String email;
    @NotBlank
    private final String user;
    @NotBlank
    private final String password;
}
