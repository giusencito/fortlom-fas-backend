package com.example.fortlomfas.backend.services.userservice.resource.Artist;


import com.example.fortlomfas.backend.services.userservice.domain.model.entity.Tag;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
public class ArtistResource {
    private Long id;

    private String username;

    private String realname;

    private String lastname;

    private String email;

    private String password;

    private byte[] content;

    private Long artistfollowers;

    private String instagramLink;

    private String facebookLink;

    private String twitterLink;

    private Set<Tag> tags;
}
