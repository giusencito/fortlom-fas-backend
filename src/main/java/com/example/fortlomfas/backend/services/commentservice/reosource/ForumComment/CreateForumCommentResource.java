package com.example.fortlomfas.backend.services.commentservice.reosource.ForumComment;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CreateForumCommentResource {
    private String commentdescription;

    private Date registerdate;
}
