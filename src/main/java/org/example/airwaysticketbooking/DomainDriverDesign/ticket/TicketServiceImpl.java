package org.example.airwaysticketbooking.DomainDriverDesign.ticket;

import lombok.RequiredArgsConstructor;
import org.example.airwaysticketbooking.DomainDriverDesign.flight.Flight;
import org.example.airwaysticketbooking.DomainDriverDesign.flight.FlightRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;
    private final FlightRepository flightRepository;

    @Override
    @Transactional
    public Ticket bookTicket(TicketDTO ticketDTO) {
        Flight flight = flightRepository.findById(ticketDTO.getFlightId())
                .orElseThrow(() -> new IllegalArgumentException("Flight not found"));

        if (flight.getAvailableSeats() <= 0) {
            throw new IllegalStateException("No seats available");
        }

        Ticket ticket = new Ticket();
        ticket.setFlight(flight);
        ticket.setPassengerName(ticketDTO.getPassengerName());
        ticket.setPassengerEmail(ticketDTO.getPassengerEmail());
        ticket.setPrice(flight.getPricePerSeat());

        flight.setAvailableSeats(flight.getAvailableSeats() - 1);
        flightRepository.save(flight);

        return ticketRepository.save(ticket);
    }
}
