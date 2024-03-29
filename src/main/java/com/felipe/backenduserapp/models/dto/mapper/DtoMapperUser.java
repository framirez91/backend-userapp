package com.felipe.backenduserapp.models.dto.mapper;

import com.felipe.backenduserapp.models.dto.UserDto;
import com.felipe.backenduserapp.models.entities.User;

public class DtoMapperUser {


    private User user;
     
  

    private DtoMapperUser() {
        
    }

    public static DtoMapperUser builder(){

        return  new DtoMapperUser();


    }

    public DtoMapperUser setUser(User user) {
        this.user = user;
        return this;
    }

    public UserDto build(){
        if (user == null) {
           throw new RuntimeException("debe setear el usuario antes de llamar a build");
        }
        boolean isAdmin = user.getRoles().stream().anyMatch(r -> "ROLE_ADMIN".equals(r.getName()));
        return new UserDto(this.user.getId(), this.user.getUsername(), this.user.getEmail(),isAdmin);
       

    }

}
