package com.aleksandar_simeunovic.user_service.request;

import com.aleksandar_simeunovic.user_service.model.UserDetails;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserUpdateRequest {
    @NotBlank(message = "Id is required")
    private String id;
    private String username;
    private String password;
    private UserDetails userDetails;
}
