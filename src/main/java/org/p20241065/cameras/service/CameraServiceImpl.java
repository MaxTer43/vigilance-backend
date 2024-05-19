package org.p20241065.cameras.service;

import org.p20241065.cameras.domain.model.entity.Camera;
import org.p20241065.cameras.domain.persistence.CameraRepository;
import org.p20241065.cameras.domain.service.CameraService;
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
public class CameraServiceImpl implements CameraService {

    private static final String ENTITY = "Camera";

    private final CameraRepository cameraRepository;

    private final Validator validator;

    public CameraServiceImpl(CameraRepository cameraRepository, Validator validator){
        this.cameraRepository = cameraRepository;
        this.validator = validator;
    }

    @Override
    public List<Camera> getAll(){
        return cameraRepository.findAll();
    }

    @Override
    public Page<Camera> getAll(Pageable pageable){
        return cameraRepository.findAll(pageable);
    }

    @Override
    public Camera getById(Long id){
        return cameraRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public Camera create(Camera camera){
        Set<ConstraintViolation<Camera>> violations = validator.validate(camera);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return cameraRepository.save(camera);
    }
}
