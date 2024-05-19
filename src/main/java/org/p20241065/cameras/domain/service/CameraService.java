package org.p20241065.cameras.domain.service;

import org.p20241065.cameras.domain.model.entity.Camera;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CameraService {

    List<Camera> getAll();

    Page<Camera> getAll(Pageable pageable);

    Camera getById(Long CameraId);

    Camera create(Camera camera);
}
