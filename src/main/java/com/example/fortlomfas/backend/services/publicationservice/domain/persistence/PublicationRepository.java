package com.example.fortlomfas.backend.services.publicationservice.domain.persistence;
import com.example.fortlomfas.backend.services.publicationservice.domain.model.entity.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicationRepository extends JpaRepository<Publication,Long>{
    List<Publication> findByArtistId(Long artistId);
}
