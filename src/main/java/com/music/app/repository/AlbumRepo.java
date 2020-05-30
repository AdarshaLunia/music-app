/*
 * Copyright (c) 2020 Astar Solutions - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 * Proprietary and confidential . Written by Team Astar ,2020
 */

package com.music.app.repository;

import com.music.app.model.Album;
import com.music.app.model.Artists;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepo extends JpaRepository<Album, Long> {
    String s = "SELECT * FROM Album WHERE id = :id AND gener = :gener ORDER BY album_name ASC, year(release_date) DESC";

    // @Query(value = s, nativeQuery = true)
    List<Album> findByArtist(Artists id);

    Album findByArtistAndId(Artists id, int albumId);
}
