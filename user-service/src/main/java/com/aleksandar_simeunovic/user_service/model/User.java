package com.aleksandar_simeunovic.user_service.model;

import com.aleksandar_simeunovic.user_service.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Entity(name = "users")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false, updatable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Embedded
    private UserDetails userDetails;
}
