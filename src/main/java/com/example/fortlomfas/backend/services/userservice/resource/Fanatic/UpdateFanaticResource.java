package com.example.fortlomfas.backend.services.userservice.resource.Fanatic;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateFanaticResource {
    private String username;

    private String realname;

    private String lastname;

    private String email;

    private String password;

    private String FanaticAlias;
}
