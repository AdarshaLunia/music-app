/*
 * Copyright (c) 2020 Astar Solutions - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 * Proprietary and confidential . Written by Team Astar ,2020
 */

package com.music.app;

import com.music.app.controller.ArtistsController;
import com.music.app.model.Artists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ControllerLayerTests {

    @Autowired
    private ArtistsController artistsController;

    @Test
    public void getArtistTestCase() {
        ResponseEntity<Page<Artists>> response = artistsController.getArtists("adarsha", 1,"");
        assertNotNull(response);
        assertNotNull(response.getStatusCode());
        assertEquals(200, response.getStatusCode());
    }




}
