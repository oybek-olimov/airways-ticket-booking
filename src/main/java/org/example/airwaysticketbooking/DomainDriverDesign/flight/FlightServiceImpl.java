package org.example.airwaysticketbooking.DomainDriverDesign.flight;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;

    @Override
    public Flight addFlight(FlightDTO flightDTO) {
        Flight flight = new Flight();
        flight.setAirline(flightDTO.getAirline());
        flight.setDepartureCity(flightDTO.getDepartureCity());
        flight.setDestinationCity(flightDTO.getDestinationCity());
        flight.setDepartureTime(flightDTO.getDepartureTime());
        flight.setArrivalTime(flightDTO.getArrivalTime());
        flight.setAvailableSeats(flightDTO.getAvailableSeats());
        flight.setPricePerSeat(flightDTO.getPricePerSeat());
        return flightRepository.save(flight);
    }

    @Override
    public List<Flight> searchFlights(String departureCity, String destinationCity) {
        return flightRepository.findByDepartureCityAndDestinationCity(departureCity, destinationCity);
    }

    @Override
    public Flight updateFlight(Long id, FlightDTO flightDTO) {
        Flight flight = flightRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Flight not found"));

        flight.setAirline(flightDTO.getAirline());
        flight.setDepartureCity(flightDTO.getDepartureCity());
        flight.setDestinationCity(flightDTO.getDestinationCity());
        flight.setDepartureTime(flightDTO.getDepartureTime());
        flight.setArrivalTime(flightDTO.getArrivalTime());
        flight.setAvailableSeats(flightDTO.getAvailableSeats());
        flight.setPricePerSeat(flightDTO.getPricePerSeat());

        return flightRepository.save(flight);
    }

    @Override
    public void deleteFlight(Long id) {
        if (!flightRepository.existsById(id)) {
            throw new IllegalArgumentException("Flight not found");
        }
        flightRepository.deleteById(id);
    }
}
