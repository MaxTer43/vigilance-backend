package org.p20241065.units.service;

import org.p20241065.shared.exception.ResourceNotFoundException;
import org.p20241065.shared.exception.ResourceValidationException;
import org.p20241065.units.domain.model.entity.Unit;
import org.p20241065.units.domain.persistence.UnitRepository;
import org.p20241065.units.domain.service.UnitService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class UnitServiceImpl implements UnitService {

    private static final String ENTITY = "Unit";

    private final UnitRepository unitRepository;

    private final Validator validator;

    public UnitServiceImpl(UnitRepository unitRepository, Validator validator){
        this.unitRepository = unitRepository;
        this.validator = validator;
    }

    @Override
    public List<Unit> getAll(){
        return unitRepository.findAll();
    }

    @Override
    public Page<Unit> getAll(Pageable pageable){
        return unitRepository.findAll(pageable);
    }

    @Override
    public Unit getById(Long id){
        return unitRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public Unit create(Unit unit){
        Set<ConstraintViolation<Unit>> violations = validator.validate(unit);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return unitRepository.save(unit);
    }
}
