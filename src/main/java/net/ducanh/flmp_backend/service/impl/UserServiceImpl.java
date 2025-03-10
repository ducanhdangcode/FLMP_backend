package net.ducanh.flmp_backend.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import net.ducanh.flmp_backend.dto.UserDto;
import net.ducanh.flmp_backend.entity.CustomEntity.PersonalFormation;
import net.ducanh.flmp_backend.entity.User;
import net.ducanh.flmp_backend.exception.ResourceNotFoundException;
import net.ducanh.flmp_backend.mapper.UserMappers;
import net.ducanh.flmp_backend.repository.UserRepository;
import net.ducanh.flmp_backend.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = UserMappers.mapToUser(userDto);
        User savedUser = userRepository.save(user);
        return UserMappers.mapToUserDto(savedUser);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map((user) -> UserMappers.mapToUserDto(user)).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(Long userId, UserDto updatedUser) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User is not existed with the given id: "
                 + userId)
        );
        user.setUsername(updatedUser.getUsername());
        user.setPassword(updatedUser.getPassword());
        user.setFirstname(updatedUser.getFirstname());
        user.setLastname(updatedUser.getLastname());
        user.setEmail(updatedUser.getEmail());
        user.setAvatar(updatedUser.getAvatar());
        user.setFavoriteTeams(updatedUser.getFavoriteTeams());
        user.setRoles(updatedUser.getRoles());
        user.setPersonalFormations(updatedUser.getPersonalFormations());

        User updatedUserObj = userRepository.save(user);

        return UserMappers.mapToUserDto(updatedUserObj);
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public boolean updateUserAttribute(String username, String email, String firstname, String lastname) {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (email != null && !email.isEmpty()) {
                user.setEmail(email);
            }
            if (firstname != null && !firstname.isEmpty()) {
                user.setFirstname(firstname);
            }
            if (lastname != null && !lastname.isEmpty()) {
                user.setLastname(lastname);
            }
            userRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public UserDto updateUserPersonalFormations(Long userId, PersonalFormation personalFormation) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User is not existed with the given id: "
                        + userId)
        );
        user.getPersonalFormations().add(personalFormation);
        userRepository.save(user);

        return UserMappers.mapToUserDto(user);
    }

    @Override
    public UserDto updateUserSpecifiedFormation(Long userId, int formationIndex, PersonalFormation personalFormation) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User is not existed with the given id: "
                        + userId)
        );
        List<PersonalFormation> personalFormations = user.getPersonalFormations();
        if (formationIndex < 0 || formationIndex >= personalFormations.size()) {
            throw new IllegalArgumentException("Invalid formation index: " + formationIndex);
        }
        personalFormations.set(formationIndex, personalFormation);
        userRepository.save(user);
        return UserMappers.mapToUserDto(user);
    }

    @Override
    public UserDto deleteUserSpecifiedFormation(Long userId, int formationIndex) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User is not existed with the given id: "
                        + userId)
        );
        List<PersonalFormation> personalFormations = user.getPersonalFormations();
        if (formationIndex < 0 || formationIndex >= personalFormations.size()) {
            throw new IllegalArgumentException("Invalid formation index: " + formationIndex);
        }
        personalFormations.remove(formationIndex);
        user.setPersonalFormations(new ArrayList<>(personalFormations));
        userRepository.save(user);
        return UserMappers.mapToUserDto(user);
    }

    @Override
    public String deleteUserById(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User not found with the given id: " + userId)
        );
        userRepository.deleteById(userId);
        return "Delete user successfully!";
    }

    @Override
    public UserDto updateUserAvatar(Long userId, String avatarLink) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User not found with the given id: " + userId)
        );
        user.setAvatar(avatarLink);
        User savedUser = userRepository.save(user);
        return UserMappers.mapToUserDto(savedUser);
    }

    @Override
    public UserDto addFavoriteTeam (Long userId, int favoriteTeamId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User not found with the given id: " + userId)
        );
        List<Integer> favoriteTeams = user.getFavoriteTeams();
        favoriteTeams.add(favoriteTeamId);
        user.setFavoriteTeams(new ArrayList<>(favoriteTeams));
        User savedUser = userRepository.save(user);
        return UserMappers.mapToUserDto(savedUser);
    }

    @Override
    public UserDto removeFavoriteTeam(Long userId, int favoriteTeamId) {
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User not found with the given id: " + userId)
        );
        List<Integer> favoriteTeams = user.getFavoriteTeams();
        favoriteTeams.removeIf(id -> id == favoriteTeamId);
        user.setFavoriteTeams(new ArrayList<>(favoriteTeams));
        User savedUser = userRepository.save(user);
        return UserMappers.mapToUserDto(savedUser);
    }

    @Override
    public UserDto updateUserByUsername(String username, UserDto updatedUser) {
        User user = userRepository.findByUsername(username).orElseThrow(
                () -> new ResourceNotFoundException("User not found with the given username: " + username)
        );
        user.setUsername(updatedUser.getUsername());
        user.setPassword(updatedUser.getPassword());
        user.setFirstname(updatedUser.getFirstname());
        user.setLastname(updatedUser.getLastname());
        user.setEmail(updatedUser.getEmail());
        user.setAvatar(updatedUser.getAvatar());
        user.setFavoriteTeams(updatedUser.getFavoriteTeams());
        user.setRoles(updatedUser.getRoles());
        user.setPersonalFormations(updatedUser.getPersonalFormations());

        User savedUser = userRepository.save(user);
        return UserMappers.mapToUserDto(savedUser);
    }
}
