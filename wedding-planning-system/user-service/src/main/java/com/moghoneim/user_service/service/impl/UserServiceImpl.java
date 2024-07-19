package com.moghoneim.user_service.service.impl;

import com.moghoneim.user_service.dto.UserDto;
import com.moghoneim.user_service.dto.mapper.UserMapper;
import com.moghoneim.user_service.model.UserEntity;
import com.moghoneim.user_service.repository.UserRepository;
import com.moghoneim.user_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public void registerUser(UserDto userDto) {
        userRepository.save(userMapper.toEntity(userDto));
    }

    @Override
    public void deleteUser(Long id) {
        Optional<UserEntity> user = userRepository.findById(id);
        if(user.isPresent()) {
            userRepository.delete(user.get());
        }
    }

    @Override
    public List<UserDto> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto)
                .toList();
    }

    @Override
    public void updateUser(String userEmail, UserDto userDto) {
        Optional<UserEntity> user = userRepository.findByEmail(userEmail);
        if(user.isPresent()){
            user.get().setFirstName(userDto.getFirstName());
            user.get().setLastName(userDto.getLastName());
            user.get().setEmail(userDto.getEmail());
            user.get().setPassword(userDto.getPassword());
            userRepository.save(user.get());
        }
    }



}
