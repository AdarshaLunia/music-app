/*
 * Copyright (c) 2020 Astar Solutions - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 * Proprietary and confidential . Written by Team Astar ,2020
 */

package com.music.app.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Gener {

    POP("POP"), ROCK("ROCK"), JAZZ("JAZZ");

    private String name;

    @JsonValue
    public String getName() {
        return name;
    }

    Gener(String name) {
        this.name = name;
    }
}
