package net.ducanh.flmp_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.Pair;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "color")
    private String color;

    @Column(name = "Trophies")
    private List<Integer> trophies;

    @Column(name = "Chairman-name")
    private String chairmanName;

    @Column(name = "Chairman-description", columnDefinition = "TEXT", length = 10000000)
    private String chairmanDescription;

    @Column(name = "Video-links")
    private List<String> videoLinks;

    @Column(name = "Favorite-state")
    private String favoriteState;

    @Column(name = "ChairmanImage", length = 10000000)
    private String chairmanImage;

    @Column(name = "KitsImage", length = 1000000000)
    private List<String> kitsImage;

    @Column(name = "VideoTitles", length = 10000)
    private List<String> videoTitles;
}
