package com.newsprringsecurity.service;

import com.newsprringsecurity.entity.PropertyUser;
import com.newsprringsecurity.payload.PropertyUserDto;
import com.newsprringsecurity.repository.PropertyUserRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserService {

    private PropertyUserRepository propertyUserRepository;

    public UserService(PropertyUserRepository propertyUserRepository) {
        this.propertyUserRepository = propertyUserRepository;
    }
    public PropertyUser addUser(PropertyUserDto dto){
        PropertyUser user = new PropertyUser();
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setUserName(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(BCrypt.hashpw(dto.getPassword(),BCrypt.gensalt(10)));
    }
}
