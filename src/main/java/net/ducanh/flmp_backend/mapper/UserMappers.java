package net.ducanh.flmp_backend.mapper;

import net.ducanh.flmp_backend.dto.UserDto;
import net.ducanh.flmp_backend.entity.User;

public class UserMappers {
    public static UserDto mapToUserDto (User user) {
        return new UserDto(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                user.getFirstname(),
                user.getLastname(),
                user.getAvatar(),
                user.getFavoriteTeams(),
                user.getRoles()
        );
    }

    public static User mapToUser (UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getUsername(),
                userDto.getPassword(),
                userDto.getEmail(),
                userDto.getFirstname(),
                userDto.getLastname(),
                userDto.getAvatar(),
                userDto.getFavoriteTeams(),
                userDto.getRoles()
        );
    }
}
