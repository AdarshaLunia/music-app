/*
 * Copyright (c) 2020 Astar Solutions - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 * Proprietary and confidential . Written by Team Astar ,2020
 */

package com.music.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Artists implements Serializable {

    @Id
    @GeneratedValue
    private Long artistId;
    @Column(unique = true)
    private String name;
    private String profileDescription;

    @JsonIgnore
    @OneToMany(mappedBy = "artists", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Album> albumSet;

}
