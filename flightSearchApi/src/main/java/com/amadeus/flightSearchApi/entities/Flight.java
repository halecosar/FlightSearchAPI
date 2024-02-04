package com.amadeus.flightSearchApi.entities;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor


@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_id", columnDefinition = "serial")
    private Long id;

    @ManyToOne  (fetch = FetchType.EAGER)
    @JoinColumn(name = "departure_airport_id", referencedColumnName = "airport_id")
    private Airport departureAirport;

    @ManyToOne  (fetch = FetchType.EAGER)
    @JoinColumn(name = "arrival_airport_id", referencedColumnName = "airport_id")
    private Airport arrivalAirport;

    @Column(name = "departure_date")
    private LocalDateTime departureDate;

    @Column(name = "arrival_date")
    private LocalDateTime arrivalDate;

    @Column(name = "price")
    private double price;



}
