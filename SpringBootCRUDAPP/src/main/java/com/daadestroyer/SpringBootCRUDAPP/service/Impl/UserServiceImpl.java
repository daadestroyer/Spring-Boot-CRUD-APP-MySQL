package com.daadestroyer.SpringBootCRUDAPP.service.Impl;

import com.daadestroyer.SpringBootCRUDAPP.dto.UserDto;
import com.daadestroyer.SpringBootCRUDAPP.entity.User;
import com.daadestroyer.SpringBootCRUDAPP.exceptionhandling.ResourceAlreadyExistedException;
import com.daadestroyer.SpringBootCRUDAPP.exceptionhandling.ResourceNotFoundException;
import com.daadestroyer.SpringBootCRUDAPP.repository.UserRepo;
import com.daadestroyer.SpringBootCRUDAPP.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {

        User user = this.modelMapper.map(userDto, User.class);
        Optional<User> savedUser = this.userRepo.findById(user.getUserId());
        if (savedUser.isPresent()) {
            throw new ResourceAlreadyExistedException("user", user.getUserId());
        }
        User userSaved = this.userRepo.save(user);
        return this.modelMapper.map(userSaved, UserDto.class);

    }

    @Override
    public List<UserDto> getAllUser() {
        List<UserDto> listOfUserDto = this.userRepo.findAll().stream().map(user -> this.modelMapper.map(user, UserDto.class)).collect(Collectors.toList());

        if (listOfUserDto.size() == 0) {
            throw new ResourceNotFoundException("User List");
        }
        return listOfUserDto;
    }

    @Override
    public UserDto getUser(Long userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", userId));
        UserDto userDto = this.modelMapper.map(user, UserDto.class);
        return userDto;
    }

    @Override
    public UserDto updateUser(User user) {
        User savedUser = this.userRepo.findById(user.getUserId()).orElseThrow(() -> new ResourceNotFoundException("User", user.getUserId()));

        savedUser.setUserId(user.getUserId());
        savedUser.setFirstName(user.getFirstName());
        savedUser.setLastName(user.getLastName());
        savedUser.setEmail(user.getEmail());
        User save = this.userRepo.save(savedUser);
        return this.modelMapper.map(save,UserDto.class);
    }
    
    @Override
    public String deleteUser(Long userId) {
        User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", userId));
        this.userRepo.delete(user);
        return "User with id " + userId + " deleted";
    }

    public User saveUser(User user){
        return this.userRepo.save(user);
    }
}
