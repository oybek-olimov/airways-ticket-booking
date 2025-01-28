package org.example.airwaysticketbooking.DomainDriverDesign.ticket;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query("SELECT t FROM Ticket t WHERE t.passengerEmail = :passengerEmail AND t.flight.departureTime BETWEEN :startDate AND :endDate")
    List<Ticket> findByPassengerEmailAndBookingDateBetween(
            @Param("passengerEmail") String passengerEmail,
            @Param("startDate") LocalDateTime startDate,
            @Param("endDate") LocalDateTime endDate
    );

    List<Ticket> findByPassengerEmail(String passengerEmail);
}