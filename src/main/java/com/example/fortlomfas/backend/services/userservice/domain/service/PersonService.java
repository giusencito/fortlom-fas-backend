package com.example.fortlomfas.backend.services.userservice.domain.service;

import com.example.fortlomfas.backend.services.userservice.domain.model.entity.Person;
import com.example.fortlomfas.backend.util.Image.ImageModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;
public interface PersonService {
    Optional<Person> getbyNombreUsuarioOrEmail(String nombreOremail);

    void save(Person usuario);

    Optional<Person> getByTokenPassword(String tokenPassword);

    Person getById(Long artistId);

    void updatephoto(Long artistId, MultipartFile file) throws IOException;

    ResponseEntity<byte[]> getprofileimage(Long userID);

    ImageModel getImageDetails(Long MultimediaID);

    Person updateprofile(Long userId, Person request);

    Person updatepassword(Long userId, Person request);
}
