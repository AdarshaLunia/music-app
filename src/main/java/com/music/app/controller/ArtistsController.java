/*
 * Copyright (c) 2020  - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 * Proprietary and confidential . Written by Team  ,2020
 */

package com.music.app.controller;

import com.music.app.adapter.DiscogsAdapter;
import com.music.app.model.Album;
import com.music.app.model.Artists;
import com.music.app.response.entity.AlbumResponse;
import com.music.app.response.entity.ArtistResponse;
import com.music.app.service.IArtistsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class ArtistsController {

    @Autowired
    IArtistsService artistsService;

    @Autowired
    DiscogsAdapter discogsAdapter;


    @GetMapping("v1/artists/")
    public ResponseEntity<Page<Artists>> getArtists(@RequestParam String name,
                                                    @RequestParam(defaultValue = "0") int page,
                                                    @RequestParam String sortBy) {
        Page<Artists> artists = artistsService.getArtists(name, page, sortBy);
        return ResponseEntity.ok().body(artists);
    }

    @PostMapping("v1/artists/")
    public ArtistResponse saveArtist(@RequestBody @Valid Artists artists) {
        return artistsService.save(artists);
    }

    @PutMapping("v1/artists/")
    public ArtistResponse updateArtist(@RequestParam String artistId, @RequestBody @Valid Artists artists) {
        return artistsService.updateArtist(artistId, artists);

    }

    @PutMapping("v1/artists/album")
    public ArtistResponse saveAlbum(@RequestParam Optional<Integer> artistId, @RequestBody @Valid List<Album> albums) {
        return artistsService.updateAlbum(artistId, albums);
    }

    @GetMapping("v1/artists/album")
    public AlbumResponse getAllAlbum(@RequestParam Optional<Integer> artistId, @RequestParam Optional<String> gener) {
        return artistsService.getAlbum(artistId, gener);
    }

    @GetMapping("v1/artists/album")
    public AlbumResponse getSingleAlbumV1(@RequestParam int artistId, @RequestParam int albumId) {
        return artistsService.getSingleAlbum(artistId, albumId);
    }

    @GetMapping("v2/artists/album")
    public AlbumResponse getSingleAlbumV2(@RequestParam int artistId, @RequestParam int albumId) {
        return discogsAdapter.getAlbum(artistId, albumId);
    }

    public ArtistResponse updateAlbum(@RequestParam Optional<Integer> artistId, @RequestParam Optional<String> albumId,
                                      @RequestBody @Valid Artists artists) {
        return null;
    }


}
