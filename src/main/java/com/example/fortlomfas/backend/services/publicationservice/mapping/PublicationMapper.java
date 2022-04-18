package com.example.fortlomfas.backend.services.publicationservice.mapping;


import com.example.fortlomfas.backend.services.publicationservice.domain.model.entity.Publication;
import com.example.fortlomfas.backend.services.publicationservice.resource.publication.CreatePublicationResource;
import com.example.fortlomfas.backend.services.publicationservice.resource.publication.PublicationResource;
import com.example.fortlomfas.backend.services.publicationservice.resource.publication.UpdatePublicationResource;
import com.example.fortlomfas.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import java.io.Serializable;
import java.util.List;
public class PublicationMapper implements Serializable{

    @Autowired
    EnhancedModelMapper mapper;

    public PublicationResource toResource(Publication model) {
        return mapper.map(model, PublicationResource.class);
    }

    public Page<PublicationResource> modelListToPage(List<Publication> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, PublicationResource.class), pageable, modelList.size());
    }
    public Publication toModel(CreatePublicationResource resource) {

        return mapper.map(resource, Publication.class);
    }

    public Publication toModel(UpdatePublicationResource resource) {

        return mapper.map(resource, Publication.class);
    }
}
