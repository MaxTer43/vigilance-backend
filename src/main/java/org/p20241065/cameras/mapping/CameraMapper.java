package org.p20241065.cameras.mapping;

import org.p20241065.cameras.domain.model.entity.Camera;
import org.p20241065.cameras.resource.*;
import org.p20241065.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class CameraMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public CameraResource toResource(Camera model){
        return mapper.map(model, CameraResource.class);
    }

    public Page<CameraResource> modelListPage(List<Camera> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, CameraResource.class), pageable, modelList.size());
    }

    public Camera toModel(CreationCameraResource resource){
        return mapper.map(resource, Camera.class);
    }

    public Camera toModel(UpdateCameraResource resource){
        return mapper.map(resource, Camera.class);
    }
}
