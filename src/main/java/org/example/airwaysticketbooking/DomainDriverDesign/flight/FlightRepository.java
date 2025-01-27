package org.example.airwaysticketbooking.DomainDriverDesign.flight;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, Long> {
    List<Flight> findByDepartureCityAndDestinationCity(String departureCity, String destinationCity);
}
