package org.p20241065.users.mapping;

import org.p20241065.shared.mapping.EnhancedModelMapper;
import org.p20241065.users.domain.model.entity.User;
import org.p20241065.users.resource.UserResource;
import org.p20241065.users.resource.CreationUserResource;
import org.p20241065.users.resource.UpdateUserResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class UserMapper implements Serializable {

    @Autowired
    EnhancedModelMapper mapper;

    public UserResource toResource(User model){
        return mapper.map(model, UserResource.class);
    }

    public Page<UserResource> modelListPage(List<User> modelList, Pageable pageable){
        return new PageImpl<>(mapper.mapList(modelList, UserResource.class), pageable, modelList.size());
    }

    public User toModel(CreationUserResource resource){
        return mapper.map(resource, User.class);
    }

    public User toModel(UpdateUserResource resource){
        return mapper.map(resource, User.class);
    }
}
