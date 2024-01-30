package com.mekanapp.mekanms.place;

import com.mekanapp.mekanms.exception.ErrorMessages;
import com.mekanapp.mekanms.exception.PlaceException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class PlaceService {

    private final PlaceRepository repository;
    private final PlaceMapper placeMapper;

    public UUID createPlace(PlaceCreateDto placeCreateDto) {
        Place newPlace = new Place();
        BeanUtils.copyProperties(placeCreateDto, newPlace);
        newPlace.setPlaceStatus(PlaceStatuses.ACTIVE.toString());
        Place responsePlace = repository.save(newPlace);

        return responsePlace.getId();
    }

    public Page<PlaceDto> getPlaces(String placeName, Pageable page) {
        if(placeName.isEmpty()) {
            throw PlaceException.withStatusAndMessage(HttpStatus.NOT_FOUND, ErrorMessages.PLACE_NOT_FOUND);
        }
        else {

            Page<PlaceDto> existPlaces = repository.findByPlaceName(placeName, page);

            if(!existPlaces.getContent().isEmpty()){
                return existPlaces;
            }
            else if(existPlaces.getContent().isEmpty()) {
                String lowerPlaceName = placeName.toLowerCase();
                return repository.findByPlaceNameContaining(lowerPlaceName, page).map(placeMapper::toDto);
            }
            else {
                throw PlaceException.withStatusAndMessage(HttpStatus.NOT_FOUND, ErrorMessages.PLACE_NOT_FOUND);
            }

        }
    }

}
