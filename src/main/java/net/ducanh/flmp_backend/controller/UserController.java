package net.ducanh.flmp_backend.controller;

import lombok.AllArgsConstructor;
import net.ducanh.flmp_backend.dto.UserDto;
import net.ducanh.flmp_backend.entity.User;
import net.ducanh.flmp_backend.service.UserService;
import org.hibernate.sql.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {
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

    static class RegisterResponse {
        private String token;

        public RegisterResponse (String token) {
            this.token = token;
        }

        public String getToken () {
            return this.token;
        }
    }

    static class ErrorResponse {
        private String message;

        public ErrorResponse (String message) {
            this.message = message;
        }

        public String getMessage () {
            return this.message;
        }
    }
}
