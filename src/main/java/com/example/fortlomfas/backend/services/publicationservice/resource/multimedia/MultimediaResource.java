package com.example.fortlomfas.backend.services.publicationservice.resource.multimedia;

import com.example.fortlomfas.backend.services.publicationservice.resource.publication.PublicationResource;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MultimediaResource {

    private Long id;
    private byte[] content;
    private PublicationResource publication;}

