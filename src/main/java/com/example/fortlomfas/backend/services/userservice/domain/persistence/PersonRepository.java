package com.example.fortlomfas.backend.services.userservice.domain.persistence;
import com.example.fortlomfas.backend.services.userservice.domain.model.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long>{


    Optional<Person> findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    Optional<Person> findByUsernameOrEmail(String username,String email);

    Optional<Person> findByTokenpassword(String tokenpassword);




}
