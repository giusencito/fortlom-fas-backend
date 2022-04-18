package com.example.fortlomfas.backend.services.userservice.domain.service;
import com.example.fortlomfas.backend.services.userservice.domain.model.entity.Rol;
import com.example.fortlomfas.backend.services.userservice.domain.model.enumeration.RolName;

import java.util.List;
import java.util.Optional;
public interface RolService {
    Optional<Rol> findByName(RolName name);

    void seed();

    List<Rol> getAll();
}
