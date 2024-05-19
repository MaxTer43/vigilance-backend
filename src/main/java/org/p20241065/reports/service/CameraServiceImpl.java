package org.p20241065.reports.service;

import org.p20241065.reports.domain.model.entity.Report;
import org.p20241065.reports.domain.persistence.ReportRepository;
import org.p20241065.reports.domain.service.ReportService;
import org.p20241065.shared.exception.ResourceNotFoundException;
import org.p20241065.shared.exception.ResourceValidationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class ReportServiceImpl implements ReportService {

    private static final String ENTITY = "Report";

    private final ReportRepository reportRepository;

    private final Validator validator;

    public ReportServiceImpl(ReportRepository reportRepository, Validator validator){
        this.reportRepository = reportRepository;
        this.validator = validator;
    }

    @Override
    public List<Report> getAll(){
        return reportRepository.findAll();
    }

    @Override
    public Page<Report> getAll(Pageable pageable){
        return reportRepository.findAll(pageable);
    }

    @Override
    public Report getById(Long id){
        return reportRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public Report create(Report report){
        Set<ConstraintViolation<Report>> violations = validator.validate(report);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return reportRepository.save(report);
    }
}
