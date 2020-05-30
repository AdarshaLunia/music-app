/*
 * Copyright (c) 2020 Astar Solutions - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 * Proprietary and confidential . Written by Team Astar ,2020
 */

package com.music.app.response.entity;

import com.music.app.model.Album;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
public class AlbumResponse extends Response {

    private List<Album> albumList;

    private Album album;

    public AlbumResponse(int status_code, String message) {
        super(status_code, message);
    }

    public AlbumResponse(int status_code, String message, List<Album> albumList) {
        super(status_code, message);
        this.albumList = albumList;
    }

    public AlbumResponse(int status_code, String message, Album album) {
        super(status_code, message);
        this.album = album;
    }
}
