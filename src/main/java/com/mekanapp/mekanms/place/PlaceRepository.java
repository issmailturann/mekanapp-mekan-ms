package com.mekanapp.mekanms.place;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.UUID;

public interface PlaceRepository extends JpaRepository<Place, UUID> {

    Page<PlaceDto> findByPlaceName(String placeName, Pageable pageable);

    @Query("SELECT p FROM Place p WHERE LOWER(p.placeName) LIKE %:placeName%")
    Page<Place> findByPlaceNameContaining(@Param("placeName") String placeName, Pageable pageable);


}
