package org.p20241065.reports.mapping;

import org.p20241065.reports.domain.model.entity.Report;
import org.p20241065.reports.resource.ReportResource;
import org.p20241065.reports.resource.CreationReportResource;
import org.p20241065.reports.resource.UpdateReportResource;
import org.p20241065.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class ReportMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public ReportResource toResource(Report model){
        return mapper.map(model, ReportResource.class);
    }

    public Page<ReportResource> modelListPage(List<Report> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, ReportResource.class), pageable, modelList.size());
    }

    public Report toModel(CreationReportResource resource){
        return mapper.map(resource, Report.class);
    }

    public Report toModel(UpdateReportResource resource){
        return mapper.map(resource, Report.class);
    }
}
