package com.example.fortlomfas.backend.services.commentservice.domain.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.fortlomfas.backend.services.forumservice.domain.model.entity.Forum;
import lombok.*;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@With
@AllArgsConstructor
@Table(name="forumcomments")
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class ForumComment extends Comment{
    @ManyToOne(targetEntity = Forum.class)
    @JoinColumn(name = "forumid")
    private Forum forum;
}
