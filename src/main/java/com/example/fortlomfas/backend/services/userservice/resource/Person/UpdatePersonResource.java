package com.example.fortlomfas.backend.services.userservice.resource.Person;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdatePersonResource {

    private String realname;

    private String lastname;

    private String email;

    private String password;
}
