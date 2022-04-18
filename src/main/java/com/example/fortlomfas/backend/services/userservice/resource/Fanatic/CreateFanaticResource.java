package com.example.fortlomfas.backend.services.userservice.resource.Fanatic;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateFanaticResource {
    private String username;

    private String realname;

    private String lastname;

    private String email;

    private String password;

    private String fanaticalias;
}
