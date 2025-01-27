package org.example.airwaysticketbooking.DomainDriverDesign.ticket;

import lombok.Data;

@Data
public class TicketDTO {
    private Long flightId;
    private String passengerName;
    private String passengerEmail;
}
