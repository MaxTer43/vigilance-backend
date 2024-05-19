package org.p20241065.units.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.p20241065.units.domain.service.UnitService;
import org.p20241065.units.mapping.UnitMapper;
import org.p20241065.units.resource.UnitResource;
import org.p20241065.units.resource.CreationUnitResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Unit", description = "Painting")
@RestController
@RequestMapping(value = "api/v1/units")
public class UnitController {

    private final UnitService service;
    private final UnitMapper mapper;

    public UnitController(UnitService service, UnitMapper mapper){
        this.mapper = mapper;
        this.service = service;
    }

    @GetMapping
    public Page<UnitResource> getAllUnits(Pageable pageable){
        return mapper.modelListPage(service.getAll(), pageable);
    }

    @GetMapping("{unitId}")
    public UnitResource getUnitById(@PathVariable("unitId") Long unitId){
        return mapper.toResource(service.getById(unitId));
    }

    @PostMapping
    public ResponseEntity<UnitResource> createUnit(CreationUnitResource resource){
        return new ResponseEntity<>(mapper.toResource(service.create(
                mapper.toModel(resource))), HttpStatus.CREATED);
    }
}
