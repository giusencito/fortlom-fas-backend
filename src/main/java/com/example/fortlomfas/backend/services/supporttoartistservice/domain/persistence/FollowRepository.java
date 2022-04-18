package com.example.fortlomfas.backend.services.supporttoartistservice.domain.persistence;

import com.example.fortlomfas.backend.services.supporttoartistservice.domain.model.entity.Follow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface FollowRepository extends JpaRepository<Follow,Long> {
    List<Follow> findByFanaticId(Long FanaticId);
    List<Follow> findByArtistId(Long ArtistId);
}