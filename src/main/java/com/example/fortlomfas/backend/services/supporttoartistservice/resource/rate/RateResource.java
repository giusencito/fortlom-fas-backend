package com.example.fortlomfas.backend.services.supporttoartistservice.resource.rate;

import com.example.fortlomfas.backend.services.userservice.resource.Artist.ArtistResource;
import com.example.fortlomfas.backend.services.userservice.resource.Fanatic.FanaticResource;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RateResource {
    private Long id;
    private Long rates;
    private ArtistResource artist;
    private FanaticResource fanatic;
}
