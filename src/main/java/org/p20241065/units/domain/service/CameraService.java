package org.p20241065.units.domain.service;

import org.p20241065.units.domain.model.entity.Unit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UnitService {

    List<Unit> getAll();

    Page<Unit> getAll(Pageable pageable);

    Unit getById(Long UnitId);

    Unit create(Unit unit);
}
