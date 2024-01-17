package com.felipe.backenduserapp.services;

import java.util.List;
import java.util.Optional;

import com.felipe.backenduserapp.models.dto.UserDto;
import com.felipe.backenduserapp.models.entities.User;
import com.felipe.backenduserapp.models.request.UserRequest;


public interface UserService {
    
    List<UserDto> findAll();

    Optional<UserDto> findById(Long id);

    UserDto save(User user);
    Optional<UserDto> update(UserRequest user, Long id);

    void remove(Long id);
}
