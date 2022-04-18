package com.example.fortlomfas.backend.services.userservice.domain.service;

import com.example.fortlomfas.backend.services.userservice.domain.model.entity.Rol;
import com.example.fortlomfas.backend.services.userservice.domain.model.entity.Tag;
import com.example.fortlomfas.backend.services.userservice.domain.model.enumeration.RolName;
import com.example.fortlomfas.backend.services.userservice.domain.model.enumeration.TagName;

import java.util.List;
import java.util.Optional;

public interface TagService {
    Optional<Tag> findByName(TagName name);

    void seed();

    List<Tag> getAll();
}
