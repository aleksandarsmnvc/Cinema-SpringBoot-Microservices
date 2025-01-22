package com.aleksandar_simeunovic.authentification_server.exc;

import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Builder
@Getter
public class ValidationException {
    private Map<String, String> validationErrors;
}
