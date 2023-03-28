package com.example.restaurant.service;

import com.example.restaurant.dto.UserDto;
import com.example.restaurant.model.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<User> getAllUser();
}
