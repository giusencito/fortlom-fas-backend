package com.example.fortlomfas.backend.services.publicationservice.resource.publication;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class UpdatePublicationResource {
    private String publicationname;
    private String publicationdescription;
    private Long likes;
    private Date date;
}