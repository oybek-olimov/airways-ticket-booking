package org.example.airwaysticketbooking.DomainDriverDesign.flight;

import java.util.List;

public interface FlightService {

    Flight addFlight(FlightDTO flightDTO);

    List<Flight> searchFlights(String departureCity, String destinationCity);

    Flight updateFlight(Long id, FlightDTO flightDTO);

    void deleteFlight(Long id);
}
