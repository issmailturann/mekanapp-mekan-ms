package com.mekanapp.mekanms.place;

import jakarta.validation.constraints.NotNull;

public record PlaceCreateDto(
        @NotNull
        String placeName,
        @NotNull
        String placeAddress,
        @NotNull
        String placePhoneNumber
) {
}
