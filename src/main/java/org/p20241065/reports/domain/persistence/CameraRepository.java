package org.p20241065.reports.domain.persistence;

import org.p20241065.reports.domain.model.entity.Report;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReportRepository extends JpaRepository<Report, Long>{
    @Override
    List<Report> findAll();
}
