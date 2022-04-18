package com.example.fortlomfas.backend.services.userservice.service;


import com.example.fortlomfas.backend.services.userservice.domain.model.entity.Rol;
import com.example.fortlomfas.backend.services.userservice.domain.model.enumeration.RolName;
import com.example.fortlomfas.backend.services.userservice.domain.persistence.RolRepository;
import com.example.fortlomfas.backend.services.userservice.domain.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class RolServiceImpl implements RolService {

    @Autowired
    RolRepository rolRepository;

    private static String[] DEFAULT_ROLES = {"Role_Fanatic","Role_Artist","ADMIN","Premium_Fanatic","Premium_Artist"};

    @Override
    public Optional<Rol> findByName(RolName name) {
        return rolRepository.findByName(name);
    }

    @Override
    public void seed() {
        Arrays.stream(DEFAULT_ROLES).forEach(name -> {
            RolName roleName = RolName.valueOf(name);
            if(!rolRepository.existsByName(roleName)) {
                rolRepository.save((new Rol()).withName(roleName));
            }
        } );
    }

    @Override
    public List<Rol> getAll() {
        return rolRepository.findAll();
    }
}
