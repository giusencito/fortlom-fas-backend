package com.example.fortlomfas.backend.services.commentservice.domain.model.entity;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.fortlomfas.backend.services.publicationservice.domain.model.entity.Publication;
import lombok.*;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@With
@AllArgsConstructor
@Table(name="publicationcomments")
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class PublicationComment extends Comment{
    @ManyToOne(targetEntity = Publication.class)
    @JoinColumn(name = "publicationid")
    private Publication publication;

}
