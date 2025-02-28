package net.ducanh.flmp_backend.entity.CustomEntity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class PlayerContract {
    private String teamName;
    private String startContractDate;
    private String endContractDate;
    private String contractType;
    private double contractValue;
}
