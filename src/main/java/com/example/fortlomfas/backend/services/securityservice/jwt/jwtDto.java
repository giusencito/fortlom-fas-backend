package com.example.fortlomfas.backend.services.securityservice.jwt;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class jwtDto {
    private String token;

    public jwtDto() {
    }

    public jwtDto(String token) {
        this.token = token;
    }
}
