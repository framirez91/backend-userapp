package com.felipe.backenduserapp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.felipe.backenduserapp.models.entities.User;

public interface UserRepository
        extends CrudRepository<User, Long> {

                Optional<User> findByUsername(String username);
                
                @Query("SELECT u FROM User u WHERE u.username = ?1")//sirve para hacer consultas personalizadas ?1 es el primer parametro
                Optional<User> getUserByUsername(String username);


}
