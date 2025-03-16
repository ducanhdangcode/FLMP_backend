package net.ducanh.flmp_backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "stadiums")
public class Stadium {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;

   @Column(name = "name")
   private String name;

   @Column(name = "team-name")
   private String teamName;

   @Column(name = "total-seat")
   private String totalSeat;

   @Column(name = "location")
   private String location;

   @Column(name = "open-date")
   private String openDate;

   @Column(name = "construction-cost")
   private String constructionCost;

   @Column(name = "image-link", length = 2000000)
   private String imageLink;
}
