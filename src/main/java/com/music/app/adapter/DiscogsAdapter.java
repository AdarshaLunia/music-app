/*
 * Copyright (c) 2020 Astar Solutions - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 * Proprietary and confidential . Written by Team Astar ,2020
 */

package com.music.app.adapter;

import com.music.app.response.entity.AlbumResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class DiscogsAdapter {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    RestTemplate restTemplate;

    private String url;

    //setting up the HTTP Basic Authentication header value
    String authorizationHeader = "Basic " + "";

    public AlbumResponse getAlbum(int artistId, int albumId) {

        AlbumResponse albumResponse = new AlbumResponse();


        HttpHeaders requestHeaders = new HttpHeaders();
        //set up HTTP Basic Authentication Header
        requestHeaders.add("Authorization", authorizationHeader);
        requestHeaders.add("Accept", MediaType.APPLICATION_JSON_VALUE);

        //request entity is created with request headers
        HttpEntity<String> requestEntity = new HttpEntity<>(requestHeaders);

        //adding the query params to the URL
        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("artistId", artistId)
                .queryParam("albumId", albumId);

        System.out.println(uriBuilder.toUriString());

        ResponseEntity<String> responseEntity = restTemplate.exchange(
                uriBuilder.toUriString(),
                HttpMethod.GET,
                requestEntity,
                String.class
        );

        if (responseEntity.getStatusCode() == HttpStatus.OK) {
            System.out.println("response received");
            System.out.println(responseEntity.getBody());
        } else {
            System.out.println("error occurred");
            System.out.println(responseEntity.getStatusCode());
        }

        return albumResponse;
    }

}
