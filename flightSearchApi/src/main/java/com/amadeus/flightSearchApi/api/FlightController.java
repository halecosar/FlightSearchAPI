package com.amadeus.flightSearchApi.api;

import com.amadeus.flightSearchApi.business.abstracts.IFlightService;
import com.amadeus.flightSearchApi.entities.Flight;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/flights")
public class FlightController {

    private final IFlightService flightService;

    public FlightController(IFlightService flightService) {
        this.flightService = flightService;
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Flight save(@RequestBody Flight flight) { //entitiy'i gönderdik.
        return this.flightService.save(flight);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public Flight update (@RequestBody Flight flight) {
        return this.flightService.update(flight);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    void delete (@PathVariable("id") Long id){
        this.flightService.delete(id);
    }
    @GetMapping("/getById/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Flight getById(@PathVariable("id") Long id) {
        return this.flightService.getById(id);
    }
}
