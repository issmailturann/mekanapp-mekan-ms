package com.mekanapp.mekanms.place;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@Data
@Entity
@Table(name = "places", schema = "util_sch")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Place {

    @Id
    @Column(name = "place_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "place_name")
    private String placeName;
    @Column(name = "place_address")
    private String placeAddress;
    @Column(name = "place_phone_number")
    private String placePhoneNumber;
    @Column(name = "status")
    private String placeStatus;

}
