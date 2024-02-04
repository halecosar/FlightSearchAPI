package com.amadeus.flightSearchApi.business.concretes;

import com.amadeus.flightSearchApi.business.abstracts.IFlightService;
import com.amadeus.flightSearchApi.business.abstracts.ISearchService;
import com.amadeus.flightSearchApi.dao.IFlight;
import com.amadeus.flightSearchApi.dto.Request.SearchDTO;
import com.amadeus.flightSearchApi.entities.Flight;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class SearchManager implements ISearchService {
    private final IFlight flightRepo;
    private final EntityManager entityManager;

    public SearchManager(IFlight flightRepo, EntityManager entityManager) {
        this.flightRepo = flightRepo;
        this.entityManager = entityManager;
    }
    @Override
    public List<Flight> search(SearchDTO searchDTO) {
        List<Flight> departureList = null;

        if(searchDTO.getArrivalDate() == null){
            String jpql = "SELECT f FROM Flight f " +
                    "WHERE f.arrivalAirport.id = :arrival_airport_id  AND " +
                    "f.departureAirport.id = :departure_airport_id AND " +
                    "f.departureDate  = :departure_date";

            Query query = entityManager.createQuery(jpql, Flight.class);
            query.setParameter("arrival_airport_id", searchDTO.getArrivalAirportId());
            query.setParameter("departure_airport_id", searchDTO.getDepartureAirportId());
            query.setParameter("departure_date", searchDTO.getDepartureDate());

            departureList = query.getResultList();
            return departureList;
        }
        else{
            String jpql2 = "SELECT f FROM Flight f " +
                    "WHERE f.arrivalAirport.id = :arrival_airport_id  AND " +
                    "f.departureAirport.id = :departure_airport_id AND " +
                    "f.departureDate  = :departure_date";

            Query query2 = entityManager.createQuery(jpql2, Flight.class);
            query2.setParameter("arrival_airport_id", searchDTO.getArrivalAirportId());
            query2.setParameter("departure_airport_id", searchDTO.getDepartureAirportId());
            query2.setParameter("departure_date", searchDTO.getDepartureDate());

            List<Flight> gidis= query2.getResultList();

            String jpql3 = "SELECT f FROM Flight f " +
                    "WHERE f.arrivalAirport.id = :arrival_airport_id  AND " +
                    "f.departureAirport.id = :departure_airport_id AND " +
                    "f.departureDate  = :departure_date";

            Query query3 = entityManager.createQuery(jpql2, Flight.class);
            query3.setParameter("arrival_airport_id", searchDTO.getDepartureAirportId());
            query3.setParameter("departure_airport_id", searchDTO.getArrivalAirportId());
            query3.setParameter("departure_date", searchDTO.getArrivalDate());

            List<Flight> donus= query3.getResultList();

            List<Flight> flights = Stream.concat(gidis.stream(), donus.stream())
                    .collect(Collectors.toList());

            return flights;
        }
    }
}
