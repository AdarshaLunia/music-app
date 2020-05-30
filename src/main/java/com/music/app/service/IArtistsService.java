/*
 * Copyright (c) 2020 Astar Solutions - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 * Proprietary and confidential . Written by Team Astar ,2020
 */

package com.music.app.service;

import com.music.app.model.Album;
import com.music.app.model.Artists;
import com.music.app.response.entity.AlbumResponse;
import com.music.app.response.entity.ArtistResponse;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface IArtistsService {
    Page<Artists> getArtists(String name, int page, String sortBy);

    ArtistResponse save(Artists artists);

    ArtistResponse updateArtist(String artistId, Artists artists);

    ArtistResponse updateAlbum(Optional<Integer> artistId, List<Album> album);

    AlbumResponse getAlbum(Optional<Integer> artistId,Optional<String> gener);

    AlbumResponse getSingleAlbum(int artistId, int albumId);
}
