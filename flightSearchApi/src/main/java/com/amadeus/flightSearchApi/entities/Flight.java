package com.amadeus.flightSearchApi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Column(name = "departureAirport")
    private String departureAirport; //kalkış havalimanı

    @Column(name = "arrivalAirport")
    private String arrivalAirport; // varış havalimanı

    @Column(name = "price")
    private double price;



}
