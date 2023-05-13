package com.lgm.backend.model.mainDb;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "match")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String slug;

    @Column(name = "match_type")
    private String matchType;

    @Column(name = "number_of_games")
    private Integer numberOfGames;

    @ManyToOne
    @JoinColumn(name = "tournament_id")
    private Tournament tournament;

    private String status;

    private Boolean draw;

    @ManyToOne
    @JoinColumn(name = "winner_id")
    private Team winner;

    @Column(name = "original_scheduled_at")
    private LocalDateTime originalScheduledAt;

    @Column(name = "scheduled_at")
    private LocalDateTime scheduledAt;

    @Column(name = "begin_at")
    private LocalDateTime beginAt;

    @Column(name = "end_at")
    private LocalDateTime endAt;

}
