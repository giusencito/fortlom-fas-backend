package com.example.fortlomfas.backend.services.userservice.domain.persistence;
import com.example.fortlomfas.backend.services.userservice.domain.model.entity.Rol;
import com.example.fortlomfas.backend.services.userservice.domain.model.enumeration.RolName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RolRepository extends JpaRepository<Rol,Long>{
    Optional<Rol> findByName(RolName name);
    boolean existsByName(RolName name);
}
