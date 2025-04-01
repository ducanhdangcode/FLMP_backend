package net.ducanh.flmp_backend.entity.CustomEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

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

    @Column(name = "time-post", updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "full-news", length = 100000000)
    private String fullNews;

    public PersonalDetailNews(String title, String description, String newsImageLink, String authorName, String fullNews) {
        this.title = title;
        this.description = description;
        this.newsImageLink = newsImageLink;
        this.authorName = authorName;
        this.fullNews = fullNews;
        this.createdAt = LocalDateTime.now(); // Auto-set time post
    }
}
