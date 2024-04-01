package com.newsprringsecurity.controller;

import com.newsprringsecurity.entity.PropertyUser;
import com.newsprringsecurity.payload.PropertyUserDto;
import com.newsprringsecurity.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //@RequestMapping(name ="/addUser",method = RequestMethod.POST)
    @PostMapping("/addUser")
    public ResponseEntity<String> addUser(PropertyUserDto dto){
        userService.addUser(dto);
        return new ResponseEntity<>("signed up successful", HttpStatus.CREATED);
    }
}
