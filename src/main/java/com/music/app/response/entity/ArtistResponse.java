/*
 * Copyright (c) 2020 Astar Solutions - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 * Proprietary and confidential . Written by Team Astar ,2020
 */

package com.music.app.response.entity;

import com.music.app.model.Artists;
import lombok.*;
import org.springframework.data.domain.Page;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ArtistResponse extends Response{

    private Page<Artists> artists;

    public ArtistResponse(int status_code, String message, Page<Artists> artists) {
        super(status_code, message);
        this.artists = artists;
    }

}
