package com.felipe.backenduserapp.services;

import java.util.List;
import java.util.Optional;

import com.felipe.backenduserapp.models.entities.User;
import com.felipe.backenduserapp.models.request.UserRequest;


public interface UserService {
    
    List<User> findAll();

    Optional<User> findById(Long id);

    User save(User user);
    Optional<User> update(UserRequest user, Long id);

    void remove(Long id);
}
