package org.p20241065.cameras.api;

import org.p20241065.cameras.domain.service.CameraService;
import org.p20241065.cameras.mapping.CameraMapper;
import org.p20241065.cameras.resource.CreationCameraResource;
import org.p20241065.cameras.resource.CameraResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Camera", description = "Painting")
@RestController
@RequestMapping(value = "api/v1/cameras")
public class CameraController {

    private final CameraService service;
    private final CameraMapper mapper;

    public CameraController(CameraService service, CameraMapper mapper){
        this.mapper = mapper;
        this.service = service;
    }

    @GetMapping
    public Page<CameraResource> getAllCameras(Pageable pageable){
        return mapper.modelListPage(service.getAll(), pageable);
    }

    @GetMapping("{cameraId}")
    public CameraResource getCameraById(@PathVariable("cameraId") Long cameraId){
        return mapper.toResource(service.getById(cameraId));
    }

    @PostMapping
    public ResponseEntity<CameraResource> createCamera(CreationCameraResource resource){
        return new ResponseEntity<>(mapper.toResource(service.create(
                mapper.toModel(resource))), HttpStatus.CREATED);
    }
}
