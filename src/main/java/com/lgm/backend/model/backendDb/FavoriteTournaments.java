package com.lgm.backend.model.backendDb;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FavoriteTournaments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @Column(name = "tournament_id")
    private Integer idTournament;

    public FavoriteTournaments(User userId, Integer idTournament) {
        this.userId = userId;
        this.idTournament = idTournament;
    }
}
