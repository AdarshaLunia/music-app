/*
 * Copyright (c) 2020 Astar Solutions - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 * Proprietary and confidential . Written by Team Astar ,2020
 */

package com.music.app.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Album implements Serializable {


    @Id
    @GeneratedValue
    @Column(name = "albumId")
    private Long id;
    private String albumName;

    @Temporal(TemporalType.DATE)
    private Date releaseDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "artistId", nullable = false)
    private Artists artists;

    @Enumerated(EnumType.STRING)
    private Gener gener;

}
