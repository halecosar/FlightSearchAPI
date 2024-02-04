package com.amadeus.flightSearchApi.business.concretes;

import com.amadeus.flightSearchApi.business.abstracts.IAirportService;
import com.amadeus.flightSearchApi.dao.IAirport;
import com.amadeus.flightSearchApi.entities.Airport;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
public class AirportManager implements IAirportService {

    private final IAirport airportRepo;
    private final EntityManager entityManager;

    public AirportManager(IAirport iAirport, IAirport airportRepo, EntityManager entityManager) {
        this.airportRepo = airportRepo;
        this.entityManager = entityManager;
    }

    @Override
    public Airport save(Airport airport) {
        return this.airportRepo.save(airport);
    }

    @Override
    public Airport update(Airport airport) {
        return this.airportRepo.save(airport);
    }

    @Override
    public Airport getById(Long id) {
        Airport airport = this.airportRepo.findById(id).orElse(null);
        if (airport == null) {
            throw new RuntimeException(id + " id’li kayıt sistemde bulunamadı.");
        } else {
            return airport;
        }
    }

    @Override
    public void delete(Long id) {
        getById(id);
        this.airportRepo.deleteById(id);
    }
}
