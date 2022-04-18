package com.example.fortlomfas.backend.configuration;

import com.example.fortlomfas.backend.services.commentservice.mapping.ForumCommentMapper;
import com.example.fortlomfas.backend.services.commentservice.mapping.PublicationCommentMapper;
import com.example.fortlomfas.backend.services.eventservice.mapping.EventMapper;
import com.example.fortlomfas.backend.services.forumservice.mapping.ForumMapper;
import com.example.fortlomfas.backend.services.publicationservice.mapping.MultimediaMapper;
import com.example.fortlomfas.backend.services.publicationservice.mapping.PublicationMapper;
import com.example.fortlomfas.backend.services.reportservice.mapping.ReportMapper;
import com.example.fortlomfas.backend.services.supporttoartistservice.mapping.FollowMapper;
import com.example.fortlomfas.backend.services.supporttoartistservice.mapping.RateMapper;
import com.example.fortlomfas.backend.services.userservice.mapping.ArtistMapper;
import com.example.fortlomfas.backend.services.userservice.mapping.FanaticMapper;
import com.example.fortlomfas.backend.services.userservice.mapping.PersonMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("FortlomMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public FanaticMapper fanaticMapper() {
        return new FanaticMapper();
    }

    @Bean
    public ArtistMapper artistMapper() {
        return new ArtistMapper();
    }

    @Bean
    public ForumMapper forumMapper() {
        return new ForumMapper();
    }

    @Bean
    public PublicationMapper publicationMapper(){
        return new PublicationMapper();
    }

    @Bean
    public PublicationCommentMapper publicationCommentMapper(){
        return new PublicationCommentMapper();
    }

    @Bean
    public EventMapper eventMapper(){
        return new EventMapper();
    }

    @Bean
    public ForumCommentMapper forumcommentMapper(){ return new ForumCommentMapper(); }

    @Bean
    public FollowMapper followMapper(){ return new FollowMapper(); }


    @Bean
    public RateMapper rateMapper(){ return new RateMapper(); }


    @Bean
    public ReportMapper reportMapper(){ return new ReportMapper(); }

    @Bean
    public MultimediaMapper multimediaMapper(){ return new MultimediaMapper(); }

    @Bean
    public PersonMapper personMapper(){ return new PersonMapper(); }
}
