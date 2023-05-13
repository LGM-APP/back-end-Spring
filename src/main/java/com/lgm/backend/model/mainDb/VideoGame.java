package com.lgm.backend.model.mainDb;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "videogame")
public class VideoGame {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String slug;

    @Column(name = "current_version")
    private String currentVersion;


    public VideoGame(String name, String slug, String currentVersion) {
        this.name = name;
        this.slug = slug;
        this.currentVersion = currentVersion;
    }
}
