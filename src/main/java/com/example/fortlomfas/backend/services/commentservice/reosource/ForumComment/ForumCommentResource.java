package com.example.fortlomfas.backend.services.commentservice.reosource.ForumComment;
import com.example.fortlomfas.backend.services.forumservice.resource.ForumResource;
import com.example.fortlomfas.backend.services.userservice.resource.Person.PersonResource;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ForumCommentResource {

    private Long id;

    private String commentdescription;

    private Date registerdate;

    private PersonResource person;

    private ForumResource forum;
}
