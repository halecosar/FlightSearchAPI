package com.amadeus.flightSearchApi.business.abstracts;

import com.amadeus.flightSearchApi.entities.Airport;
import com.amadeus.flightSearchApi.entities.Flight;

public interface IFlightService {

    Flight save (Flight flight);
    Flight update (Flight flight);
    Flight getById(Long id);
    void delete(Long id);
}
