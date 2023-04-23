package com.daadestroyer.SpringBootCRUDAPP.controller;

import com.daadestroyer.SpringBootCRUDAPP.dto.UserDto;
import com.daadestroyer.SpringBootCRUDAPP.entity.User;
import com.daadestroyer.SpringBootCRUDAPP.service.Impl.UserServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/save-user")
    public ResponseEntity<?> saveUser(@Valid @RequestBody UserDto userDto) {
        UserDto savedUser = this.userService.createUser(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.OK);
    }

    @GetMapping("/get-all-user")
    public ResponseEntity<?> getAllUser() {
        List<UserDto> allUser = this.userService.getAllUser();
        return new ResponseEntity<>(allUser, HttpStatus.OK);
    }

    @GetMapping("/get-user/{userId}")
    public ResponseEntity<?> getUser(@PathVariable Long userId) {
        UserDto user = this.userService.getUser(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/update-user/{userId}")
    public ResponseEntity<?> updateUser(@Valid @RequestBody UserDto userDto) {
        UserDto updatedUser = this.userService.updateUser(userDto);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/delete-user/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        String message = this.userService.deleteUser(userId);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}
