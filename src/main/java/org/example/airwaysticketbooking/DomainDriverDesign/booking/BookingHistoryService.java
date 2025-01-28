package org.example.airwaysticketbooking.DomainDriverDesign.booking;


import lombok.RequiredArgsConstructor;
import org.example.airwaysticketbooking.DomainDriverDesign.ticket.Ticket;
import org.example.airwaysticketbooking.DomainDriverDesign.ticket.TicketRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingHistoryService {

    private final TicketRepository ticketRepository;

    public List<Ticket> getBookingHistory(String email, LocalDateTime startDate, LocalDateTime endDate) {
        if (startDate != null && endDate != null) {
            return ticketRepository.findByPassengerEmailAndBookingDateBetween(email, startDate, endDate);
        }
        return ticketRepository.findByPassengerEmail(email);
    }
}
