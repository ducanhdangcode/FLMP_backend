package net.ducanh.flmp_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.ducanh.flmp_backend.entity.CustomEntity.TeamDetailTrophy;
import org.antlr.v4.runtime.misc.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TeamDto {
    private long id;
    private String name;
    private String color;
    private List<TeamDetailTrophy> trophies;
    private String chairmanName;
    private String chairmanDescription;
    private List<String> videoLinks;
    private String favoriteState;
    private String chairmanImage;
    private List<String> kitsImage;
    private List<String> videoTitles;
}
