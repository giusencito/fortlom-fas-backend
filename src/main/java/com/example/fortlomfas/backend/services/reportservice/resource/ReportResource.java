package com.example.fortlomfas.backend.services.reportservice.resource;

import com.example.fortlomfas.backend.services.userservice.resource.Person.PersonResource;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReportResource {
    private Long id;

    private String reportDescription;

    private PersonResource userMain;


    private PersonResource userReported;

}
