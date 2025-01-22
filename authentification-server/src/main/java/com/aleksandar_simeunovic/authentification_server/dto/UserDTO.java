package com.aleksandar_simeunovic.authentification_server.dto;

import com.aleksandar_simeunovic.authentification_server.enums.Role;
import lombok.Data;

@Data
public class UserDTO {
    private String id;
    private String username;
    private String email;
    private Role role;
}
