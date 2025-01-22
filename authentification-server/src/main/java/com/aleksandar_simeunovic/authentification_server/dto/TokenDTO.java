package com.aleksandar_simeunovic.authentification_server.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TokenDTO {
    private String token;
}
