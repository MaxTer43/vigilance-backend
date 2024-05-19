package org.p20241065.units.mapping;

import org.p20241065.shared.mapping.EnhancedModelMapper;
import org.p20241065.units.domain.model.entity.Unit;
import org.p20241065.units.resource.UnitResource;
import org.p20241065.units.resource.CreationUnitResource;
import org.p20241065.units.resource.UpdateUnitResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class UnitMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public UnitResource toResource(Unit model){
        return mapper.map(model, UnitResource.class);
    }

    public Page<UnitResource> modelListPage(List<Unit> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, UnitResource.class), pageable, modelList.size());
    }

    public Unit toModel(CreationUnitResource resource){
        return mapper.map(resource, Unit.class);
    }

    public Unit toModel(UpdateUnitResource resource){
        return mapper.map(resource, Unit.class);
    }
}
