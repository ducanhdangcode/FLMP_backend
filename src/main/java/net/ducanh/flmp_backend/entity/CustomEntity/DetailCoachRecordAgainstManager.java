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
public class DetailCoachRecordAgainstManager {
    private String managerName;
    private int matches;
    private int wins;
    private int draws;
    private int loses;
}
