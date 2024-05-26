package org.p20241065.users.service;

import org.p20241065.shared.exception.ResourceNotFoundException;
import org.p20241065.shared.exception.ResourceValidationException;
import org.p20241065.users.domain.model.entity.User;
import org.p20241065.users.domain.persistence.UserRepository;
import org.p20241065.users.domain.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    private static final String ENTITY = "User";

    private final UserRepository userRepository;

    private final Validator validator;

    public UserServiceImpl(UserRepository userRepository, Validator validator){
        this.userRepository = userRepository;
        this.validator = validator;
    }

    @Override
    public List<User> getAll(){
        return userRepository.findAll();
    }

    @Override
    public Page<User> getAll(Pageable pageable){
        return userRepository.findAll(pageable);
    }

    @Override
    public User getById(Long id){
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, id));
    }

    @Override
    public User create(User user){
        Set<ConstraintViolation<User>> violations = validator.validate(user);

        if (!violations.isEmpty())
            throw new ResourceValidationException(ENTITY, violations);

        return userRepository.save(user);
    }
}
