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
public class DetailTransfer {
    private String season;
    private String date;
    private String teamLeft;
    private String teamJoined;
    private String fee;
    private String options;
    private String teamLeftLogoLink;
    private String teamJoinedLogoLink;
    private String teamLeftCountryLink;
    private String teamJoinedCountryLink;
}
