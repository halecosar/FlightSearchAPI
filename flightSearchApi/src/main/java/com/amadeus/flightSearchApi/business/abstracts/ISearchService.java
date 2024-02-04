package com.amadeus.flightSearchApi.business.abstracts;

import com.amadeus.flightSearchApi.dto.Request.SearchDTO;
import com.amadeus.flightSearchApi.entities.Flight;

import java.util.List;

public interface ISearchService {
    List<Flight> search(SearchDTO searchDTO);
}
