package com.lgm.backend.model.mainDb;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Proxy;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Proxy(lazy = false)
@Table(name = "team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String acronym;

    @Column(name = "image_url")
    private String imageUrl;

    @JsonIgnore
    private String slug;

    private String name;

    private String location;

}