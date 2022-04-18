package com.example.fortlomfas.backend.services.supporttoartistservice.mapping;

import com.example.fortlomfas.backend.services.supporttoartistservice.domain.model.entity.Follow;
import com.example.fortlomfas.backend.services.supporttoartistservice.resource.follow.CreateFollowResource;
import com.example.fortlomfas.backend.services.supporttoartistservice.resource.follow.FollowResource;
import com.example.fortlomfas.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import java.io.Serializable;
import java.util.List;


public class FollowMapper implements Serializable{

    @Autowired
    EnhancedModelMapper mapper;

    public FollowResource toResource(Follow model) {
        return mapper.map(model, FollowResource.class);
    }

    public Page<FollowResource> modelListToPage(List<Follow> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, FollowResource.class), pageable, modelList.size());
    }
    public Follow toModel(CreateFollowResource resource) {
        return mapper.map(resource, Follow.class);
    }

}
