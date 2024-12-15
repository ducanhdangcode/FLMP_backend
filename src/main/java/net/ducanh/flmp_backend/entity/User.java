package net.ducanh.flmp_backend.entity;

import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email_id", nullable = false, unique = true)
    private String email;

    @Column(name = "first-name")
    private String firstname;

    @Column(name = "last-name")
    private String lastname;

    @Column(name = "avatar", columnDefinition = "TEXT")
    private String avatar;

    @Column(name = "favorite-teams")
    private List<Integer> favoriteTeams;
}
