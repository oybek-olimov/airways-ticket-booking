package org.example.airwaysticketbooking.DomainDriverDesign.flight;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class FlightDTO {
    private String airline;
    private String departureCity;
    private String destinationCity;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private int availableSeats;
    private double pricePerSeat;
}
