/*
 * Copyright (c) 2020 Astar Solutions - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 * Proprietary and confidential . Written by Team Astar ,2020
 */

package com.music.app.service.impl;

import com.music.app.model.Album;
import com.music.app.model.Artists;
import com.music.app.repository.AlbumRepo;
import com.music.app.repository.ArtistsRepo;
import com.music.app.response.entity.AlbumResponse;
import com.music.app.response.entity.ArtistResponse;
import com.music.app.service.IArtistsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ArtistsServiceImpl implements IArtistsService {

    @Autowired
    ArtistsRepo artistsRepo;

    @Autowired
    AlbumRepo albumRepo;

    @Override
    public Page<Artists> getArtists(String name, int page, String sortBy) {
        Optional<String> aName = Optional.ofNullable(name);
        Optional<Integer> aPage = Optional.ofNullable(page);
        Optional<String> aSortBy = Optional.ofNullable(sortBy);
        return artistsRepo.findByName(aName.orElse("_"),
                PageRequest.of(
                        aPage.orElse(0), 5,
                        Sort.Direction.ASC, aSortBy.orElse("id")));
    }

    @Override
    public ArtistResponse save(Artists artists) {
        ArtistResponse artistResponse = new ArtistResponse();
        String aName = artists.getName();
        boolean byName = artistsRepo.existsByName(aName);
        if (byName == true) {
            artistResponse.setMessage("Record Already Exitis");
            artistResponse.setStatus_code(409);
        } else {
            artistsRepo.save(artists);
            artistResponse.setStatus_code(200);
            artistResponse.setMessage("Record added");
        }

        return artistResponse;
    }

    @Override
    public ArtistResponse updateArtist(String artistId, Artists artists) {
        ArtistResponse artistResponse = new ArtistResponse();

        Optional<Artists> userFromDb = artistsRepo.findById(Long.valueOf(artistId));
        if (userFromDb.isPresent()) {
            userFromDb.get().setName(artists.getName());
            userFromDb.get().setProfileDescription(artists.getProfileDescription());
            artistsRepo.save(userFromDb.get());
            artistResponse.setMessage("Record updated");
            artistResponse.setStatus_code(200);

        } else {
            artistResponse.setMessage("Record doesn't Exitis");
            artistResponse.setStatus_code(409);
        }

        return artistResponse;
    }

    @Override
    public ArtistResponse updateAlbum(Optional<Integer> artistId, List<Album> albums) {
        ArtistResponse artistResponse = new ArtistResponse();
        List<Album> albumList = new ArrayList<>();

        if (artistId.isPresent()) {
            Optional<Artists> artists = artistsRepo.findById(Long.valueOf(artistId.get()));
            if (artists.isPresent()) {
                for (Album a : albums) {
                    System.out.println(a);
                    a.setArtists(artists.get());
                    a.setReleaseDate(new Date());
                    albumList.add(a);
                }
                albumRepo.saveAll(albumList);
                artistResponse.setMessage("Record updated");
                artistResponse.setStatus_code(200);
            }

        } else {
            artistResponse.setMessage("ArtistId Empty");
            artistResponse.setStatus_code(404);
        }

        return artistResponse;
    }

    @Override
    public AlbumResponse getAlbum(Optional<Integer> artistId, Optional<String> gener) {

        Optional<Artists> artists = artistsRepo.findById(Long.valueOf(artistId.get()));

        if (!artistId.isPresent() && !gener.isPresent()) {
            return new AlbumResponse(400, "No Result");
        } else {
            List<Album> albumList = albumRepo.findByArtist(artists.get());
            albumList.stream().forEach(System.out::println);
            return new AlbumResponse(200, "Record", albumList);
        }
    }

    @Override
    public AlbumResponse getSingleAlbum(int artistId, int albumId) {
        Album album = null;
        Optional<Artists> artists = artistsRepo.findById(Long.valueOf(artistId));
        Optional<Integer> id = Optional.ofNullable(artistId);
        if (!id.isPresent()) {
            album = albumRepo.findByArtistAndId(artists.get(), albumId);

        }
        return new AlbumResponse(200, "", album);
    }


}
