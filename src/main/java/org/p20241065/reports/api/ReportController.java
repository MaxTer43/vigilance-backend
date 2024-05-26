package org.p20241065.reports.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.p20241065.reports.domain.service.ReportService;
import org.p20241065.reports.mapping.ReportMapper;
import org.p20241065.reports.resource.ReportResource;
import org.p20241065.reports.resource.CreationReportResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Report", description = "Painting")
@RestController
@RequestMapping(value = "api/v1/reports")
public class ReportController {

    private final ReportService service;
    private final ReportMapper mapper;

    public ReportController(ReportService service, ReportMapper mapper){
        this.mapper = mapper;
        this.service = service;
    }

    @GetMapping
    public Page<ReportResource> getAllReports(Pageable pageable){
        return mapper.modelListPage(service.getAll(), pageable);
    }

    @GetMapping("{reportId}")
    public ReportResource getReportById(@PathVariable("reportId") Long reportId){
        return mapper.toResource(service.getById(reportId));
    }

    @PostMapping
    public ResponseEntity<ReportResource> createReport(CreationReportResource resource){
        return new ResponseEntity<>(mapper.toResource(service.create(
                mapper.toModel(resource))), HttpStatus.CREATED);
    }
}
