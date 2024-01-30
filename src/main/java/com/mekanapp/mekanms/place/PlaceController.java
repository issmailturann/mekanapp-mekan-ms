package com.mekanapp.mekanms.place;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
public class PlaceController implements PlaceApi {

    private final PlaceService service;

    @Override
    public ResponseEntity<UUID> createPlace(PlaceCreateDto placeCreateDto) {
        return ResponseEntity.ok(service.createPlace(placeCreateDto));
    }

    @Override
    public ResponseEntity<Page<PlaceDto>> getAllAccounts(Pageable page, String placeName) {
        return ResponseEntity.ok(service.getPlaces(placeName, page));
    }

}
