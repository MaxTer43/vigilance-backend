package org.p20241065.users.domain.service;

import org.p20241065.users.domain.model.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {

    List<User> getAll();

    Page<User> getAll(Pageable pageable);

    User getById(Long UserId);

    User create(User user);
}
