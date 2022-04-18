package com.example.fortlomfas.backend.services.reportservice.domain.model.entity;
import com.example.fortlomfas.backend.services.userservice.domain.model.entity.Person;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "reports")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull
    @NotBlank
    @Size(max = 100)
    @Column()
    private String ReportDescription;

    @ManyToOne(targetEntity = Person.class)
    @JoinColumn(name = "userMainid")
    private Person userMain;

    @ManyToOne(targetEntity = Person.class)
    @JoinColumn(name = "userReportedid")
    private Person userReported;
}
