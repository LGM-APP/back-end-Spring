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
@Table(name = "match_game")
public class MatchGame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "begin_at")
    private LocalDateTime beginAt;

    @Column(name = "end_at")
    private LocalDateTime endAt;

    @ManyToOne
    @JoinColumn(name = "match_id")
    private Match match;

    private Boolean finished;

    @ManyToOne
    @JoinColumn(name = "winner_id")
    private Team winner;

    private Boolean forfeit;

    private Integer length;

    private Boolean complete;

}
