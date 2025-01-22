package com.aleksandar_simeunovic.authentification_server.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
public class LoginRequest {
    @NotBlank
    private final String username;
    @NotBlank
    private final String password;
}
