package com.example.fortlomfas.backend.services.userservice.service;


import com.example.fortlomfas.backend.services.userservice.domain.model.entity.Artist;
import com.example.fortlomfas.backend.services.userservice.domain.model.entity.Rol;
import com.example.fortlomfas.backend.services.userservice.domain.model.entity.Tag;
import com.example.fortlomfas.backend.services.userservice.domain.model.enumeration.RolName;
import com.example.fortlomfas.backend.services.userservice.domain.model.enumeration.TagName;
import com.example.fortlomfas.backend.services.userservice.domain.persistence.ArtistRepository;
import com.example.fortlomfas.backend.services.userservice.domain.persistence.RolRepository;
import com.example.fortlomfas.backend.services.userservice.domain.persistence.TagRepository;
import com.example.fortlomfas.backend.services.userservice.domain.service.ArtistService;
import com.example.fortlomfas.backend.services.userservice.domain.service.RolService;
import com.example.fortlomfas.shared.execption.ResourceNotFoundException;
import com.example.fortlomfas.shared.execption.ResourcePerzonalized;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
@Service
public class ArtistServiceImpl implements ArtistService {


    private static final String ENTITY = "Artist";

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private TagRepository tagRepository;

    @Autowired
    RolService rolService;

    @Override
    public List<Artist> getAll() {
        return artistRepository.findAll();
    }

    @Override
    public Page<Artist> getAll(Pageable pageable) {
        return artistRepository.findAll(pageable);
    }

    @Override
    public Artist getById(Long artistId) {
        return artistRepository.findById(artistId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, artistId));
    }

    @Override
    public Artist update(Long artistId, Artist request) {
        return artistRepository.findById(artistId).map(post->{
            post.setArtistfollowers(request.getArtistfollowers());
            artistRepository.save(post);
            return  post;
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, artistId));
    }

    @Override
    public ResponseEntity<?> delete(Long artistId) {
        return artistRepository.findById(artistId).map(post -> {
            artistRepository.delete(post);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, artistId));
    }

    @Override
    public boolean existsByNombreUsuario(String nombreUsuario) {
        return artistRepository.existsByUsername(nombreUsuario);
    }

    @Override
    public boolean existsByEmail(String email) {
        return artistRepository.existsByEmail(email);
    }

    @Override
    public void save(Artist artist) {
        artistRepository.save(artist);
    }

    @Override
    public Artist getbyNombreUsuario(String nombreUsuario) {
        return artistRepository.findByUsername(nombreUsuario)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, (long)1));
    }

    @Override
    public Artist setInstagramAccount(Long artistId, Artist request) {
        return artistRepository.findById(artistId).map(post->{
            post.setInstagramLink(request.getInstagramLink());
            artistRepository.save(post);
            return  post;
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, artistId));
    }

    @Override
    public Artist setFacebookAccount(Long artistId, Artist request) {
        return artistRepository.findById(artistId).map(post->{
            post.setFacebookLink(request.getFacebookLink());
            artistRepository.save(post);
            return  post;
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, artistId));
    }

    @Override
    public Artist setTwitterAccount(Long artistId, Artist request) {
        return artistRepository.findById(artistId).map(post->{
            post.setTwitterLink(request.getTwitterLink());
            artistRepository.save(post);
            return  post;
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, artistId));
    }

    @Override
    public Optional<Artist> getbyNombreUsuarioOrEmail(String nombreOremail) {
        return artistRepository.findByUsernameOrEmail(nombreOremail,nombreOremail);
    }

    @Override
    public Artist setTag(Long artistId, String tag) {



        Optional<Tag> tagstruct=tagRepository.findByName(Enum.valueOf(TagName.class,tag));


        return artistRepository.findById(artistId).map(post->{
            Set<Tag>tags=new HashSet<>();
            tags=post.getTags();
            tags.add(tagstruct.get());
            post.setTags(tags);
            artistRepository.save(post);
            return post;

        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, artistId));
    }

    @Override
    public Artist upgradeartist(Long artistId) {
        return artistRepository.findById(artistId).map(post->{
            Set<Rol> roles = new HashSet<>();
            roles.add(rolService.findByName(RolName.Premium_Artist).get());
            post.setRoles(roles);
            artistRepository.save(post);
            return post;

        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, artistId));
    }

    @Override
    public Artist create(Artist artist) {
        if(artistRepository.existsByUsername(artist.getUsername()))
            throw  new ResourcePerzonalized("ya exsite este nombre de usuario");
        if (artistRepository.existsByEmail(artist.getEmail()))
            throw  new ResourcePerzonalized("ya exsite este correo electronico");

        return artistRepository.save(artist);
    }




}
