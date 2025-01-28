package org.example.airwaysticketbooking.DomainDriverDesign.booking;


import lombok.RequiredArgsConstructor;
import org.example.airwaysticketbooking.DomainDriverDesign.ticket.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingHistoryController {

    private final BookingHistoryService bookingHistoryService;

    @GetMapping("/history")
    public ResponseEntity<List<Ticket>> getBookingHistory(
            @RequestParam String passengerEmail,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate
    ) {
        List<Ticket> bookings = bookingHistoryService.getBookingHistory(passengerEmail, startDate, endDate);
        return ResponseEntity.ok(bookings);
    }
}
