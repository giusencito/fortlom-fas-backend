package com.example.fortlomfas.backend.services.reportservice.mapping;

import com.example.fortlomfas.backend.services.reportservice.domain.model.entity.Report;
import com.example.fortlomfas.backend.services.reportservice.resource.CreateReportResource;
import com.example.fortlomfas.backend.services.reportservice.resource.ReportResource;
import com.example.fortlomfas.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import java.io.Serializable;
import java.util.List;
public class ReportMapper implements Serializable {


    @Autowired
    EnhancedModelMapper mapper;

    public ReportResource toResource(Report model) {
        return mapper.map(model, ReportResource.class);
    }

    public Page<ReportResource> modelListToPage(List<Report> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, ReportResource.class), pageable, modelList.size());
    }

    public Report toModel(CreateReportResource resource) {
        return mapper.map(resource, Report.class);
    }

}





