package com.daadestroyer.SpringBootCRUDAPP.controller;

import com.daadestroyer.SpringBootCRUDAPP.dto.UserDto;
import com.daadestroyer.SpringBootCRUDAPP.entity.User;
import com.daadestroyer.SpringBootCRUDAPP.service.Impl.UserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "CRUD REST APIs for User Controller",
        description = "Create User, Update User, Get User, Get All User, Delete User"
)
@RestController
public class MainController {

    @Autowired
    private UserServiceImpl userService;

    @Operation(
            summary = "Create User REST APIs",
            description = "Create User REST APIs used to save user in DB"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HttpStatus 201 Created"
    )
    // http://localhost:8080/save-user

    @PostMapping("/save-user")
    public ResponseEntity<?> saveUser(@Valid @RequestBody User user) {
//        UserDto savedUser = this.userService.createUser(userDto);
//        return new ResponseEntity<>(savedUser, HttpStatus.OK);

        User savedUser = this.userService.saveUser(user);
        return new ResponseEntity<>(savedUser,HttpStatus.OK);
    }

    @Operation(
            summary = "Get User REST APIs",
            description = "Get User REST APIs used to get user from DB"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HttpStatus 201 Created"
    )
    // http://localhost:8080/get-all-user
    @GetMapping("/get-all-user")
    public ResponseEntity<?> getAllUser() {
        List<UserDto> allUser = this.userService.getAllUser();
        return new ResponseEntity<>(allUser, HttpStatus.OK);
    }

    @Operation(
            summary = "Get User by Id REST APIs",
            description = "Get User REST APIs used to get user from DB"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HttpStatus 201 Created"
    )
    // http://localhost:8080/get-user/2222
    @GetMapping("/get-user/{userId}")
    public ResponseEntity<?> getUser(@PathVariable Long userId) {
        UserDto user = this.userService.getUser(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Operation(
            summary = "Update User REST APIs",
            description = "Update User REST APIs used to update user in DB"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HttpStatus 201 Created"
    )
    // http://localhost:8080/update-user/2222
    @PutMapping("/update-user")
    public ResponseEntity<?> updateUser(@Valid @RequestBody User user) {
        UserDto updatedUser = this.userService.updateUser(user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @Operation(
            summary = "Delete User REST APIs",
            description = "Delete User REST APIs used to delete user in DB"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HttpStatus 201 Created"
    )
    // http://localhost:8080/delete-user/22222
    @DeleteMapping("/delete-user/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        String message = this.userService.deleteUser(userId);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

}
