package com.aleksandar_simeunovic.user_service.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Embeddable;
import lombok.*;

@Embeddable
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDetails {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String country;
    private String city;
    private String address;
    private String postalCode;
    private String aboutMe;
}