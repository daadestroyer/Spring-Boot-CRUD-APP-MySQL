package com.daadestroyer.SpringBootCRUDAPP.service;

import com.daadestroyer.SpringBootCRUDAPP.dto.UserDto;
import com.daadestroyer.SpringBootCRUDAPP.entity.User;

import java.util.List;

public interface UserService {
    public UserDto createUser(UserDto userDto);

    public List<UserDto> getAllUser();

    public UserDto getUser(Long userId);

    public UserDto updateUser(UserDto userDto);

    public String deleteUser(Long userId);
}
