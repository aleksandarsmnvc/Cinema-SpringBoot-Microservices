package com.aleksandar_simeunovic.authentification_server.client;

import com.aleksandar_simeunovic.authentification_server.dto.RegisterDTO;


import com.aleksandar_simeunovic.authentification_server.dto.UserDTO;
import com.aleksandar_simeunovic.authentification_server.request.RegisterRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "user-service", path = "/user")
public interface UserService {
    @PostMapping("/save")
    ResponseEntity<RegisterDTO> save(@RequestBody RegisterRequest request);

    @GetMapping("/getUserByUsername/{username}")
    ResponseEntity<UserDTO> getUserByUsername(@PathVariable String username);
}
