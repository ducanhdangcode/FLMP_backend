package net.ducanh.flmp_backend.entity.CustomEntity;

import jakarta.persistence.Column;
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
public class PersonalDetailNews {
    private String title;
    private String description;
    private String newsImageLink;
    private String authorName;
    private String timePost;

    @Column(name = "full-news", length = 100000000)
    private String fullNews;
}
