package com.example.fortlomfas.backend.services.userservice.domain.persistence;

import com.example.fortlomfas.backend.services.userservice.domain.model.entity.Rol;
import com.example.fortlomfas.backend.services.userservice.domain.model.entity.Tag;
import com.example.fortlomfas.backend.services.userservice.domain.model.enumeration.RolName;
import com.example.fortlomfas.backend.services.userservice.domain.model.enumeration.TagName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TagRepository extends JpaRepository<Tag,Long> {
    Optional<Tag> findByName(TagName name);
    boolean existsByName(TagName name);
}
