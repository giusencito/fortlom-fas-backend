package com.example.fortlomfas.backend.services.userservice.domain.model.entity;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.fortlomfas.backend.services.eventservice.domain.model.entity.Event;
import com.example.fortlomfas.backend.services.publicationservice.domain.model.entity.Publication;
import com.example.fortlomfas.backend.services.supporttoartistservice.domain.model.entity.Follow;
import com.example.fortlomfas.backend.services.supporttoartistservice.domain.model.entity.Rate;
import lombok.*;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@With
@AllArgsConstructor
@Table(name="artists")
@PrimaryKeyJoinColumn(referencedColumnName = "id")
public class Artist extends Person{

    @NotNull
    private Long artistfollowers;

    private String instagramLink;

    private String facebookLink;

    private String twitterLink;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "artist_tags",
            joinColumns = @JoinColumn(name = "artist_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags=new HashSet<>();



    @OneToMany(targetEntity = Rate.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "artistid",referencedColumnName = "id")
    private List<Rate> rate;

    @OneToMany(targetEntity = Event.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "artistid",referencedColumnName = "id")
    private List<Event> events;

    @OneToMany(targetEntity = Publication.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "artistid",referencedColumnName = "id")
    private List<Publication> publications;

    @OneToMany(targetEntity = Follow.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "artistid",referencedColumnName = "id")
    private List<Follow> follow;





}
