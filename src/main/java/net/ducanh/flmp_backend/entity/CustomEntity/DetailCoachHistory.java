package net.ducanh.flmp_backend.entity.CustomEntity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetailCoachHistory {
    private String clubName;
    private String clubLogoLink;
    private String role;
    private String appointed;
    private String inChargeUntil;
    private int matches;
    private double ppm;
}
