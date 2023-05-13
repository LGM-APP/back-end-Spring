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
@Table(name = "player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer age;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "last_name")
    private String lastName;

    private String name;

    private String nationality;

    private String role;

    private String slug;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

}
