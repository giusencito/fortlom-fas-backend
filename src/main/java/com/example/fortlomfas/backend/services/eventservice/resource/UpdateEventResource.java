package com.example.fortlomfas.backend.services.eventservice.resource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateEventResource {
    private String eventname;
    private String eventeescription;
    private Long eventlikes;
}