package com.amadeus.flightSearchApi.api;

import com.amadeus.flightSearchApi.business.abstracts.IAirportService;
import com.amadeus.flightSearchApi.business.abstracts.ISearchService;
import com.amadeus.flightSearchApi.dto.Request.SearchDTO;
import com.amadeus.flightSearchApi.entities.Flight;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/search")
public class SearchController {
    private final ISearchService searchService;

    public SearchController(ISearchService searchService) {
        this.searchService = searchService;
    }
    @PostMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public List<Flight> search(@RequestBody SearchDTO searchDTO) {
        return this.searchService.search(searchDTO);
    }
}
