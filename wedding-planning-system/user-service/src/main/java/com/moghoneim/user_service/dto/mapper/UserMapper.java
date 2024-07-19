package com.moghoneim.user_service.dto.mapper;

import com.moghoneim.user_service.dto.UserDto;
import com.moghoneim.user_service.model.UserEntity;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

     public UserDto toDto(UserEntity user){
         return UserDto.builder()
                 .firstName(user.getFirstName())
                 .lastName(user.getLastName())
                 .email(user.getEmail())
                 .password(user.getPassword())
                 .build();
     }

    public UserEntity toEntity(UserDto userDto){
        return UserEntity.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .build();
    }
}
