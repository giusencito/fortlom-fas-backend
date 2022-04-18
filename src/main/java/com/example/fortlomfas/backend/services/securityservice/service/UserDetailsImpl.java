package com.example.fortlomfas.backend.services.securityservice.service;

import com.example.fortlomfas.backend.services.securityservice.Principal.UsuarioPrincipal;
import com.example.fortlomfas.backend.services.userservice.domain.model.entity.Person;
import com.example.fortlomfas.backend.services.userservice.domain.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsImpl implements UserDetailsService{

    @Autowired
    PersonService personaService;



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person persona=personaService.getbyNombreUsuarioOrEmail(username).get();
        return UsuarioPrincipal.build(persona);
    }
}