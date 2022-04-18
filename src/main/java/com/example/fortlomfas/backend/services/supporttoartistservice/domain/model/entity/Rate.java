package com.example.fortlomfas.backend.services.supporttoartistservice.domain.model.entity;

import com.example.fortlomfas.backend.services.userservice.domain.model.entity.Artist;
import com.example.fortlomfas.backend.services.userservice.domain.model.entity.Fanatic;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@NoArgsConstructor
@Getter
@Setter
@Entity
@With
@AllArgsConstructor
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull
    private Integer rates;



    @ManyToOne(targetEntity = Artist.class)
    @JoinColumn(name = "artistid")
    private Artist artist;


    @ManyToOne(targetEntity = Fanatic.class)
    @JoinColumn(name = "fanaticid")
    private Fanatic fanatic;
}
