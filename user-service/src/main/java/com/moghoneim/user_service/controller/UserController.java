package com.moghoneim.user_service.controller;

import com.moghoneim.user_service.dto.UserDto;
import com.moghoneim.user_service.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody UserDto userDto){
        userService.registerUser(userDto);
        return ResponseEntity.ok("Registered Successfully..");
    }

    @DeleteMapping("/delete-user/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted Successfully..");
    }

    @PutMapping("/update-user/{email}")
    public ResponseEntity updateUser(@PathVariable String email, @RequestBody UserDto userDto){
        userService.updateUser(email, userDto);
        return ResponseEntity.ok("Updated Successfully..");
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers(){
        List<UserDto> users = userService.getUsers();
        return ResponseEntity.ok(users);
    }

}
