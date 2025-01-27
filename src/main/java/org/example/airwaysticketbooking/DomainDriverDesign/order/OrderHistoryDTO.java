package org.example.airwaysticketbooking.DomainDriverDesign.order;

import lombok.Data;

@Data
public class OrderHistoryDTO {
    private Long ticketId;
    private String flightDetails;
    private double price;
    private String bookingDate;
}