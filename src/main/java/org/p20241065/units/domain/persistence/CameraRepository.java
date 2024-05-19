package org.p20241065.units.domain.persistence;

import org.p20241065.units.domain.model.entity.Unit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UnitRepository extends JpaRepository<Unit, Long>{
    @Override
    List<Unit> findAll();
}
