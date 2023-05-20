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
public class Bet {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id ;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    User userId;

    @Column(name ="match_id", nullable = false)
    Integer matchId;

    @Column(name ="bet_team_id", nullable = false)
    Integer betTeamId;

    @Column(nullable = false)
    Integer amount;

    @Column(nullable = false)
    Float odd;


}
