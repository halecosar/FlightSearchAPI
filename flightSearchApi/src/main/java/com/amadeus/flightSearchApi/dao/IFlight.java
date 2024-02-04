package com.amadeus.flightSearchApi.dao;

import com.amadeus.flightSearchApi.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFlight extends JpaRepository<Flight,Long> {

}