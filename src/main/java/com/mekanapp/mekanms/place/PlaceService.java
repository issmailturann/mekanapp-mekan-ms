package com.mekanapp.mekanms.place;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class PlaceService {

    private final PlaceRepository repository;

    public UUID createPlace(PlaceCreateDto placeCreateDto) {
        Place newPlace = new Place();
        BeanUtils.copyProperties(placeCreateDto, newPlace);
        newPlace.setPlaceStatus(PlaceStatuses.ACTIVE.toString());
        Place responsePlace = repository.save(newPlace);

        return responsePlace.getId();
    }

}
