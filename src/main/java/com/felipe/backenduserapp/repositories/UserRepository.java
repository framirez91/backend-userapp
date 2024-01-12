package com.felipe.backenduserapp.repositories;

import org.springframework.data.repository.CrudRepository;
import com.felipe.backenduserapp.models.entities.User;

public interface UserRepository
        extends CrudRepository<User, Long> {

}
