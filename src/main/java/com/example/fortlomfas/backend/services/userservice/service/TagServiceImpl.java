package com.example.fortlomfas.backend.services.userservice.service;

import com.example.fortlomfas.backend.services.userservice.domain.model.entity.Rol;
import com.example.fortlomfas.backend.services.userservice.domain.model.entity.Tag;
import com.example.fortlomfas.backend.services.userservice.domain.model.enumeration.RolName;
import com.example.fortlomfas.backend.services.userservice.domain.model.enumeration.TagName;
import com.example.fortlomfas.backend.services.userservice.domain.persistence.RolRepository;
import com.example.fortlomfas.backend.services.userservice.domain.persistence.TagRepository;
import com.example.fortlomfas.backend.services.userservice.domain.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagRepository tagRepository;

    private static String[] DEFAULT_TAGS = { "Progresive_Rock","Sound_Engineering","Classic_Metal","Hard_Rock","Complex","Wave"};

    @Override
    public Optional<Tag> findByName(TagName name) {
        return tagRepository.findByName(name);
    }

    @Override
    public void seed() {
        Arrays.stream(DEFAULT_TAGS).forEach(name -> {
            TagName tagName = TagName.valueOf(name);
            if(!tagRepository.existsByName(tagName)) {
                tagRepository.save((new Tag()).withName(tagName));
            }
        } );

    }

    @Override
    public List<Tag> getAll() {
        return tagRepository.findAll();
    }
}
