package com.moghoneim.user_service.dto.mapper;

import com.moghoneim.user_service.dto.UserDto;
import com.moghoneim.user_service.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

     public UserDto toDto(User user){
         return UserDto.builder()
                 .firstName(user.getFirstName())
                 .lastName(user.getLastName())
                 .email(user.getEmail())
                 .password(user.getPassword())
                 .build();
     }

    public User toEntity(UserDto userDto){
        return User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .build();
    }
}
