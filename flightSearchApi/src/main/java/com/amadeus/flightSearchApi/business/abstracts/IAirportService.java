package com.amadeus.flightSearchApi.business.abstracts;

import com.amadeus.flightSearchApi.entities.Airport;

public interface IAirportService {

    Airport save (Airport airport);
    Airport update (Airport airport);
    Airport getById(Long id);
    void delete(Long id);
}
