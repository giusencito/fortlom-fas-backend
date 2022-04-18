package com.example.fortlomfas.backend.services.securityservice.Dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class LoginUser {


    @NotBlank
    private String nombreUsuario;

    @NotBlank
    private String password;
}
