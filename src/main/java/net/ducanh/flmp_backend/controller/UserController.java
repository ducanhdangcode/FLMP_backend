package net.ducanh.flmp_backend.controller;

import lombok.AllArgsConstructor;
import net.ducanh.flmp_backend.dto.UserDto;
import net.ducanh.flmp_backend.entity.CustomEntity.PersonalFormation;
import net.ducanh.flmp_backend.entity.User;
import net.ducanh.flmp_backend.service.UserService;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto) {
        UserDto savedUser = userService.createUser(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @PutMapping("{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable("id") Long userId, @RequestBody UserDto UpdatedUser) {
        UserDto userDto = userService.updateUser(userId, UpdatedUser);
        return ResponseEntity.ok(userDto);
    }

    @GetMapping("/{username}")
    public ResponseEntity<User> findByUsername (@PathVariable String username) {
        Optional<User> user = userService.getUserByUsername(username);
        return user.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{username}/update")
    public ResponseEntity<String> updateUserAttribute (
            @PathVariable String username,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String firstname,
            @RequestParam(required = false) String lastname
    ) {
        boolean isUpdated = userService.updateUserAttribute(username, email, firstname, lastname);
        if (isUpdated) {
            return ResponseEntity.ok("User details updated successfully");
        } else {
            return ResponseEntity.badRequest().body("User not found or no updates provided");
        }
    }

    @PutMapping("/{id}/update-formations")
    public ResponseEntity<UserDto> updateUserPersonalFormations(@PathVariable("id") Long userId,
                                                                @RequestBody PersonalFormation personalFormation) {
        UserDto userDto = userService.updateUserPersonalFormations(userId, personalFormation);
        return ResponseEntity.ok(userDto);
    }

    @PutMapping("/{id}/update-specified-formation/{formationIndex}")
    public ResponseEntity<UserDto> updateUserSpecifiedFormation(@PathVariable("id") Long userId,
                                                                @PathVariable("formationIndex") int formationIndex,
                                                                @RequestBody PersonalFormation personalFormation) {
        UserDto userDto = userService.updateUserSpecifiedFormation(userId, formationIndex, personalFormation);
        return ResponseEntity.ok(userDto);
    }

    @DeleteMapping("/{id}/delete-specified-formation/{formationIndex}")
    public ResponseEntity<UserDto> deleteUserSpecifiedFormation(@PathVariable("id") Long userId, @PathVariable(
            "formationIndex") int formationIndex) {
        UserDto userDto = userService.deleteUserSpecifiedFormation(userId, formationIndex);
        return ResponseEntity.ok(userDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserById (@PathVariable("id") Long userId) {
        String deleteMessage = userService.deleteUserById(userId);
        return ResponseEntity.ok(deleteMessage);
    }

    @PutMapping("/{id}/update-avatar")
    public ResponseEntity<UserDto> updateUserAvatar (@PathVariable("id") Long userId, @RequestBody String avatarLink) {
        UserDto userDto = userService.updateUserAvatar(userId, avatarLink);
        return ResponseEntity.ok(userDto);
    }

    @PutMapping("/{id}/add-favorite-team/{favorite-team-id}")
    public ResponseEntity<UserDto> addFavoriteTeam (@PathVariable("id") Long userId,
                                                    @PathVariable("favorite-team-id") int favoriteTeamId) {
        UserDto userDto = userService.addFavoriteTeam(userId, favoriteTeamId);
        return ResponseEntity.ok(userDto);
    }

    @PutMapping("/{id}/remove-favorite-team/{favorite-team-id}")
    public ResponseEntity<UserDto> removeFavoriteTeam (@PathVariable("id") Long userId, @PathVariable("favorite-team" +
            "-id") int favoriteTeamId) {
        UserDto userDto = userService.removeFavoriteTeam(userId, favoriteTeamId);
        return ResponseEntity.ok(userDto);
    }

    @PutMapping("/{username}/update-all")
    public ResponseEntity<UserDto> updateUserByUsername (@PathVariable("username") String username,
                                                         @RequestBody UserDto updatedUser) {
        UserDto userDto = userService.updateUserByUsername(username, updatedUser);
        return ResponseEntity.ok(userDto);
    }
}
