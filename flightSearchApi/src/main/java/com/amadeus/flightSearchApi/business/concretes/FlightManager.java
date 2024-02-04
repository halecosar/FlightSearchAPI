package com.amadeus.flightSearchApi.business.concretes;

import com.amadeus.flightSearchApi.business.abstracts.IFlightService;
import com.amadeus.flightSearchApi.dao.IFlight;
import com.amadeus.flightSearchApi.entities.Flight;
import org.springframework.stereotype.Service;
import javax.persistence.EntityManager;

@Service
public class FlightManager implements IFlightService {
    private final IFlight flightRepo;
    private final EntityManager entityManager;

    public FlightManager(IFlight flightRepo, EntityManager entityManager) {
        this.flightRepo = flightRepo;
        this.entityManager = entityManager;
    }

    @Override
    public Flight save(Flight flight) {
        return this.flightRepo.save(flight);
    }

    @Override
    public Flight update(Flight flight) {
        return this.flightRepo.save(flight);
    }

    @Override
    public Flight getById(Long id) {
        Flight flight = this.flightRepo.findById(id).orElse(null);
        if (flight == null) {
            throw new RuntimeException(id + " id’li kayıt sistemde bulunamadı.");
        } else {
            return flight;
        }

    }

    @Override
    public void delete(Long id) {
        getById(id);
        this.flightRepo.deleteById(id);
    }
}
