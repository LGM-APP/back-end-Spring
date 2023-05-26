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
public class FavoriteTeam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;

    @Column(name = "id_Team")
    private Integer idTeam;

    public FavoriteTeam(User userId, Integer idTeam) {
        this.userId = userId;
        this.idTeam = idTeam;
    }
}
