package com.example.fortlomfas.backend.services.supporttoartistservice.mapping;

import com.example.fortlomfas.backend.services.supporttoartistservice.domain.model.entity.Rate;
import com.example.fortlomfas.backend.services.supporttoartistservice.resource.rate.CreateRateResource;
import com.example.fortlomfas.backend.services.supporttoartistservice.resource.rate.RateResource;
import com.example.fortlomfas.backend.services.supporttoartistservice.resource.rate.UpdateRateResource;
import com.example.fortlomfas.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import java.io.Serializable;
import java.util.List;
public class RateMapper implements Serializable {


    @Autowired
    EnhancedModelMapper mapper;

    public RateResource toResource(Rate model) {
        return mapper.map(model, RateResource.class);
    }

    public Page<RateResource> modelListToPage(List<Rate> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, RateResource.class), pageable, modelList.size());
    }

    public Rate toModel(CreateRateResource resource) {
        return mapper.map(resource, Rate.class);
    }

    public Rate toModel(UpdateRateResource resource) {
        return mapper.map(resource, Rate.class);
    }

}