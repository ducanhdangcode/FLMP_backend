package net.ducanh.flmp_backend.service;

import net.ducanh.flmp_backend.dto.UserDto;
import net.ducanh.flmp_backend.entity.User;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);

    List<UserDto> getAllUsers();

    UserDto updateUser(Long userId, UserDto updatedUser);
}
