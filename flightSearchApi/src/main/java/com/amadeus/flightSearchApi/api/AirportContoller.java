package com.amadeus.flightSearchApi.api;

import com.amadeus.flightSearchApi.business.abstracts.IAirportService;
import com.amadeus.flightSearchApi.entities.Airport;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/airports")
public class AirportContoller {

    private final IAirportService airportService;

    public AirportContoller(IAirportService airportService) {
        this.airportService = airportService;
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Airport save(@RequestBody Airport airport) { //entitiy'i gönderdik.
        return this.airportService.save(airport);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Airport update (@RequestBody Airport airport) {
        return this.airportService.update(airport);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    void delete (@PathVariable("id") Long id){
        this.airportService.delete(id);
    }
    @GetMapping("/getById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Airport getById(@PathVariable("id") Long id) {
        return this.airportService.getById(id);
    }
}


