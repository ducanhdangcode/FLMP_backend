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
public class DetailRumour {
    private String clubLeftName;
    private String clubLeftLogoLink;
    private String clubJoinedName;
    private String clubJoinedLogoLink;
    private double probability;
}
