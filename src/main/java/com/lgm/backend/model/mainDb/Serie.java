package com.lgm.backend.model.mainDb;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "serie")
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "league_id")
    private League leagueId;

    @Column(name = "full_name")
    private String fullName;

    @JsonIgnore
    private String slug;

    @JsonIgnore
    @Column(name = "begin_at")
    private LocalDateTime beginAt;

    @JsonIgnore
    @Column(name = "end_at")
    private LocalDateTime endAt;

}
