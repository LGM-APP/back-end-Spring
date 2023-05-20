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
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id ;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    User userId;


    @Column(name ="favorite_id", nullable = false)
    Integer favoriteId;

    @Column(name ="type", nullable = false)
    String type;

}
