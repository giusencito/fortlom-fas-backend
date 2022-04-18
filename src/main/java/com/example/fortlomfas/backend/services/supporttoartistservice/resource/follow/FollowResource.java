package com.example.fortlomfas.backend.services.supporttoartistservice.resource.follow;

import com.example.fortlomfas.backend.services.userservice.resource.Artist.ArtistResource;
import com.example.fortlomfas.backend.services.userservice.resource.Fanatic.FanaticResource;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FollowResource {
    private Long id;
    private ArtistResource artist;
    private FanaticResource fanatic;
}
