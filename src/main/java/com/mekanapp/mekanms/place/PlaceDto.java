package com.mekanapp.mekanms.place;

import java.util.UUID;

public record PlaceDto(
        UUID id,
        String placeName,
        String placeAddress,
        String placePhoneNumber,
        String placeStatus
) {
}
