package com.example.fortlomfas.backend.services.commentservice.reosource.PublicationComment;
import com.example.fortlomfas.backend.services.publicationservice.resource.publication.PublicationResource;
import com.example.fortlomfas.backend.services.userservice.resource.Person.PersonResource;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class PublicationCommentResource {
    private Long id;

    private String commentdescription;

    private Date registerdate;

    private PersonResource person;

    private PublicationResource publication;
}
