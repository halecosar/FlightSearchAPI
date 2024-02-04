package com.amadeus.flightSearchApi.dao;

import com.amadeus.flightSearchApi.entities.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAirport extends JpaRepository<Airport,Long> {

}
