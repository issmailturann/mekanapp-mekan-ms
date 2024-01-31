package com.mekanapp.mekanms.place;

public record PlaceUpdateDto(
        String placeName,
        String placeAddress,
        String placePhoneNumber
) {
}
