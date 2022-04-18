package com.example.fortlomfas.backend.services.forumservice.resource;

import com.example.fortlomfas.backend.services.userservice.resource.Person.PersonResource;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ForumResource {
    private Long id;
    private String forumname;
    private String forumdescription;
    private PersonResource person;
}
