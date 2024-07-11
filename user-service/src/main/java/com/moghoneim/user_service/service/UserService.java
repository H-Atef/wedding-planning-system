package com.moghoneim.user_service.service;

import com.moghoneim.user_service.dto.UserDto;

import java.util.List;

public interface UserService {
    void registerUser(UserDto userDto);
    void deleteUser(Long id);
    List<UserDto> getUsers();
    void updateUser(String userEmail, UserDto userDto);
}
