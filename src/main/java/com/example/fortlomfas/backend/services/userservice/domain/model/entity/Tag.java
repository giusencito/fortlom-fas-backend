package com.example.fortlomfas.backend.services.userservice.domain.model.entity;

import com.example.fortlomfas.backend.services.userservice.domain.model.enumeration.RolName;
import com.example.fortlomfas.backend.services.userservice.domain.model.enumeration.TagName;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@With
@Table(name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private TagName name;
}
