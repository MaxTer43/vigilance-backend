package org.p20241065.reports.domain.service;

import org.p20241065.reports.domain.model.entity.Report;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ReportService {

    List<Report> getAll();

    Page<Report> getAll(Pageable pageable);

    Report getById(Long ReportId);

    Report create(Report report);
}
