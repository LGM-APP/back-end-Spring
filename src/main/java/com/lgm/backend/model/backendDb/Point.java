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
public class Point {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;


    Integer point = 250;

    @OneToOne
    @JoinColumn(name = "user_id")
    User user;
}
