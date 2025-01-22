package com.aleksandar_simeunovic.authentification_server.service;


import com.aleksandar_simeunovic.authentification_server.client.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserService userServiceClient;

    public CustomUserDetailsService(UserService userServiceClient) {
        this.userServiceClient = userServiceClient;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userServiceClient.getUserByUsername(username).getBody();
        assert user != null;
        return new CustomUserDetails(user);
    }
}
