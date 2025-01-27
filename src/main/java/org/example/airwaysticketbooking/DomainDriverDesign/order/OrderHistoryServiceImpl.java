package org.example.airwaysticketbooking.DomainDriverDesign.order;

import lombok.RequiredArgsConstructor;
import org.example.airwaysticketbooking.DomainDriverDesign.ticket.Ticket;
import org.example.airwaysticketbooking.DomainDriverDesign.ticket.TicketRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class OrderHistoryServiceImpl implements OrderHistoryService {

    private final TicketRepository ticketRepository;

    @Override
    public List<OrderHistoryDTO> getOrderHistory(Long userId) {
        List<Ticket> tickets = ticketRepository.findAll().stream()
                .filter(ticket -> ticket.getPassengerEmail().equalsIgnoreCase(userId.toString()))
                .toList();

        return tickets.stream().map(ticket -> {
            OrderHistoryDTO dto = new OrderHistoryDTO();
            dto.setTicketId(ticket.getId());
            dto.setFlightDetails(ticket.getFlight().getAirline() + " (" + ticket.getFlight().getDepartureCity() +
                    " -> " + ticket.getFlight().getDestinationCity() + ")");
            dto.setPrice(ticket.getPrice());
            dto.setBookingDate(ticket.getFlight().getDepartureTime().toString());
            return dto;
        }).collect(Collectors.toList());
    }
}
