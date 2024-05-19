package org.p20241065.cameras.domain.persistence;

import org.p20241065.cameras.domain.model.entity.Camera;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CameraRepository extends JpaRepository<Camera, Long>{
    @Override
    List<Camera> findAll();
}
