package com.example.fortlomfas.backend.services.reportservice.api;

import com.example.fortlomfas.backend.services.reportservice.domain.model.entity.Report;
import com.example.fortlomfas.backend.services.reportservice.domain.service.ReportService;
import com.example.fortlomfas.backend.services.reportservice.mapping.ReportMapper;
import com.example.fortlomfas.backend.services.reportservice.resource.CreateReportResource;
import com.example.fortlomfas.backend.services.reportservice.resource.ReportResource;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;





@RestController
@RequestMapping("/api/v1")
public class ReportController {



    @Autowired
    private ReportService reportservice;

    @Autowired
    private ReportMapper mapper;

    @Autowired
    private ModelMapper mapping;
    @GetMapping("/reports")
    public Page<ReportResource> getAllRates(Pageable pageable) {
        return mapper.modelListToPage(reportservice.getAll(), pageable);
    }
    @GetMapping("/reports/{reportId}")
    public ReportResource getRateById(@PathVariable("reportId") Long followId) {
        return mapper.toResource(reportservice.getById(followId));
    }
    @PostMapping("/usersmains/{UserMainId}/usersreports/{UserReportedId}/reports")
    public ReportResource createRate(@PathVariable Long UserMainId, @PathVariable Long UserReportedId, @RequestBody CreateReportResource request) {
        Report comment = mapping.map(request, Report.class);
        return mapping.map(reportservice.create(UserMainId, UserReportedId, comment), ReportResource.class);
    }
    @GetMapping("/usersmains/{UserMainId}/reports")
    public Page<ReportResource> getAllRatesByFanaticId(@PathVariable Long UserMainId,Pageable pageable) {
        return mapper.modelListToPage(reportservice.findByUserMainId(UserMainId), pageable);
    }
    @GetMapping("/usersreports/{UserReportedId}/reports")
    public Page<ReportResource> getAllRateByArtistId(@PathVariable Long UserReportedId,Pageable pageable) {
        return mapper.modelListToPage(reportservice.findByUserReportedId(UserReportedId), pageable);
    }
    @DeleteMapping("/reports/{reportId}")
    public ResponseEntity<?> deleteFollow(@PathVariable Long rateId) {
        return reportservice.delete(rateId);
    }


}
