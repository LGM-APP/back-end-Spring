package com.lgm.backend.model.mainDb;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Proxy;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.time.LocalDateTime;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Proxy(lazy = false)
@Table(name = "matchs")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @JsonIgnore
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonIgnore
    private LocalDateTime originalScheduledAt;

    @Column(name = "scheduled_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime scheduledAt;

    @Column(name = "begin_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime beginAt;

    @Column(name = "end_at")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endAt;

    @ManyToOne
    @JoinColumn(name = "home_id")
    private Team home;

    @ManyToOne
    @JoinColumn(name = "away_id")
    private Team away;

    @Column(name = "home_odd")
    private Float homeOdd;

    @Column(name = "away_odd")
    private Float awayOdd;


}
