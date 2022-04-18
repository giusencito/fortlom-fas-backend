package com.example.fortlomfas.backend.services.eventservice.service;
import com.example.fortlomfas.backend.services.eventservice.domain.model.entity.Event;
import com.example.fortlomfas.backend.services.eventservice.domain.persistence.EventRepository;
import com.example.fortlomfas.backend.services.eventservice.domain.service.EventService;
import com.example.fortlomfas.backend.services.userservice.domain.persistence.ArtistRepository;
import com.example.fortlomfas.shared.execption.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {


    private static final String ENTITY = "Event";
    private static final String ENTITY2 = "Artist";


    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private ArtistRepository artistRepository;
    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Page<Event> getAllEvents(Pageable pageable) {
        return eventRepository.findAll(pageable);
    }

    @Override
    public Event getEventById(Long eventId) {
        return eventRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, eventId));
    }

    @Override
    public Event createEvent(Long artistId, Event request) {
        return artistRepository.findById(artistId)
                .map(artists -> {
                    request.setArtist(artists);
                    return eventRepository.save(request);
                })
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY2, artistId));
    }

    @Override
    public Event updateEvent(Long eventId, Event request) {

        return eventRepository.findById(eventId).map(post->{
            post.setEventlikes(request.getEventlikes());
            eventRepository.save(post);
            return  post;
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, eventId));

    }

    @Override
    public List<Event> getEventsByArtistId(Long artistId) {
        return eventRepository.findByArtistId(artistId);
    }

    @Override
    public ResponseEntity<?> deleteEvent(Long eventId) {
        return eventRepository.findById(eventId).map(event -> {
            eventRepository.delete(event);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, eventId));
    }
}
