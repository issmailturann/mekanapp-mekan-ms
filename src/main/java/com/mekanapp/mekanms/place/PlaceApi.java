package com.mekanapp.mekanms.place;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Place")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "/api/v1/places")
@Validated
public interface PlaceApi {

    @Operation(operationId = "createPlace", summary = "Create place.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "SUCCESS", content = @Content(schema = @Schema(implementation = Boolean.class))),
            @ApiResponse(responseCode = "201", description = "Created", content = @Content(schema = @Schema(implementation = PlaceCreateDto.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = Error.class))),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(schema = @Schema(implementation = Error.class))),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(schema = @Schema(implementation = Error.class))),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = Error.class))),
            @ApiResponse(responseCode = "405", description = "Method Not Allowed", content = @Content(schema = @Schema(implementation = Error.class))),
            @ApiResponse(responseCode = "409", description = "Conflict", content = @Content(schema = @Schema(implementation = Error.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = Error.class)))
    })
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<UUID> createPlace(@RequestBody @Valid PlaceCreateDto placeCreateDto);

    @Operation(operationId = "getPlaces", summary = "Get places")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "SUCCESS", content = @Content(schema = @Schema(implementation = PlaceDto.class))),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = Error.class))),
            @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(schema = @Schema(implementation = Error.class))),
            @ApiResponse(responseCode = "403", description = "Forbidden", content = @Content(schema = @Schema(implementation = Error.class))),
            @ApiResponse(responseCode = "404", description = "Not Found", content = @Content(schema = @Schema(implementation = Error.class))),
            @ApiResponse(responseCode = "405", description = "Method Not Allowed", content = @Content(schema = @Schema(implementation = Error.class))),
            @ApiResponse(responseCode = "409", description = "Conflict", content = @Content(schema = @Schema(implementation = Error.class))),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = @Content(schema = @Schema(implementation = Error.class)))
    })
    @GetMapping(value = "/getPlaces", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Page<PlaceDto>> getAllAccounts(Pageable page, @RequestParam(required = false) String placeName);


}
