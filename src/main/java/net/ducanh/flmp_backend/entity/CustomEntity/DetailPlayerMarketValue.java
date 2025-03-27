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
public class DetailPlayerMarketValue {
    private String date;
    private double marketValue;
    private String marketValueDisplay;
    private String clubLogoLink;
    private String clubName;
    private String age;
}
