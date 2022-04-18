package com.example.fortlomfas.backend.services.eventservice.resource;

import com.example.fortlomfas.backend.services.userservice.resource.Artist.ArtistResource;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class EventResource {
    private Long id;
    private String eventname;
    private String eventeescription;
    private Long eventlikes;
    private Date registerdate;
    private ArtistResource artist;
}
