package net.ducanh.flmp_backend.service;

import net.ducanh.flmp_backend.dto.UserDto;
import net.ducanh.flmp_backend.entity.CustomEntity.PersonalFormation;
import net.ducanh.flmp_backend.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDto createUser(UserDto userDto);

    List<UserDto> getAllUsers();

    UserDto updateUser(Long userId, UserDto updatedUser);

    Optional<User> getUserByUsername (String username);

    boolean updateUserAttribute(String username, String email, String firstname, String lastname);

    UserDto updateUserPersonalFormations (Long userId, PersonalFormation personalFormation);

    UserDto updateUserSpecifiedFormation (Long userId, int formationIndex, PersonalFormation personalFormation);

    UserDto deleteUserSpecifiedFormation (Long userId, int formationIndex);

    String deleteUserById (Long userId);
}
