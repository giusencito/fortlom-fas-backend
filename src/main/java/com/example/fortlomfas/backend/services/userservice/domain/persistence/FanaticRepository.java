package com.example.fortlomfas.backend.services.userservice.domain.persistence;
import com.example.fortlomfas.backend.services.userservice.domain.model.entity.Fanatic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FanaticRepository extends JpaRepository<Fanatic,Long>{
    Optional<Fanatic> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    Optional<Fanatic> findByUsernameOrEmail(String username,String email);
}
