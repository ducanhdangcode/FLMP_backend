package net.ducanh.flmp_backend.entity.CustomEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "player-formations")
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class PlayerFormation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int number;
    private String name;
    private String position;
}
