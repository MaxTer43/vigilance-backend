package org.p20241065.users.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.p20241065.users.domain.service.UserService;
import org.p20241065.users.mapping.UserMapper;
import org.p20241065.users.resource.UserResource;
import org.p20241065.users.resource.CreationUserResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "User", description = "Painting")
@RestController
@RequestMapping(value = "api/v1/users")
public class UserController {

    private final UserService service;
    private final UserMapper mapper;

    public UserController(UserService service, UserMapper mapper){
        this.mapper = mapper;
        this.service = service;
    }

    @GetMapping
    public Page<UserResource> getAllUsers(Pageable pageable){
        return mapper.modelListPage(service.getAll(), pageable);
    }

    @GetMapping("{userId}")
    public UserResource getUserById(@PathVariable("userId") Long userId){
        return mapper.toResource(service.getById(userId));
    }

    @PostMapping
    public ResponseEntity<UserResource> createUser(CreationUserResource resource){
        return new ResponseEntity<>(mapper.toResource(service.create(
                mapper.toModel(resource))), HttpStatus.CREATED);
    }
}
