package com.aleksandar_simeunovic.authentification_server.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterDTO {
    private String id;
    private String username;
    private String email;
}
