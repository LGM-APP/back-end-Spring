package com.lgm.backend.model.mainDb;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "match_stream")
public class MatchStream {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "match_id")
    private Match match;

    @Column(name = "embed_url")
    private String embedUrl;

    private String language;

    private Boolean official;

    @Column(name = "raw_url")
    private String rawUrl;

}