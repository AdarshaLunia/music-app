/*
 * Copyright (c) 2020 Astar Solutions - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 * Proprietary and confidential . Written by Team Astar ,2020
 */

package com.music.app.repository;

import com.music.app.model.Artists;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public
interface ArtistsRepo extends JpaRepository<Artists, Long> {

    @Query("select s from Artists s where name like %?1%")
    Page<Artists> findByName(String name, PageRequest pageable);

    boolean existsByName(String name);


}
