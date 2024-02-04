package com.amadeus.flightSearchApi.dto.Request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchDTO {
    private LocalDateTime departureDate;
    private LocalDateTime arrivalDate;
    private long departureAirportId;
    private long arrivalAirportId;
}
