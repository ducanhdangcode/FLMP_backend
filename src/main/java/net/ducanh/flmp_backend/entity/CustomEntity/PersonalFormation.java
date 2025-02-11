package net.ducanh.flmp_backend.entity.CustomEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.ducanh.flmp_backend.converter.JsonConverter;
import net.ducanh.flmp_backend.entity.Player;

import java.util.List;
@Embeddable
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PersonalFormation {

    private String teamName;
    private String formationName;
    @Column(length = 100000)
    private List<PlayerFormation> mainSquad;
    @Column(length = 100000)
    private List<PlayerFormation> substitutions;

    private String formationDescription;
}
