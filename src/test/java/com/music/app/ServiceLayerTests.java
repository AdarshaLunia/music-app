/*
 * Copyright (c) 2020 Astar Solutions - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 * Proprietary and confidential . Written by Team Astar ,2020
 */

package com.music.app;

import com.music.app.response.entity.ArtistResponse;
import com.music.app.service.impl.ArtistsServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceLayerTests {

    @InjectMocks
    @Spy
    ArtistsServiceImpl artistsService;

    @Autowired
    ArtistsServiceImpl artistsServiceImpl;

    @Test
    public void getAllArtistTestCase1() {
        ArtistResponse response = (ArtistResponse) artistsServiceImpl.getArtists("", 1, "");
        assertNotNull(response);
        assertNotNull(response.getArtists());
        assertEquals(200, response.getStatus_code());
        assertNotNull(response.getMessage());
    }


}
