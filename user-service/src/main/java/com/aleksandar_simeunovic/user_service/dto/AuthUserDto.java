package com.aleksandar_simeunovic.user_service.dto;

import com.aleksandar_simeunovic.user_service.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthUserDto {
    private String id;
    private String username;
    private String password;
    private Role role;
}
