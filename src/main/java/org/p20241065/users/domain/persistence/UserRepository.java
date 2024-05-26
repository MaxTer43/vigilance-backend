package org.p20241065.users.domain.persistence;

import org.p20241065.users.domain.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>{
    @Override
    List<User> findAll();
}
