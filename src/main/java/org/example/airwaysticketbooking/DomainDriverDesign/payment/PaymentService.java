package org.example.airwaysticketbooking.DomainDriverDesign.payment;

import java.util.List;

public interface PaymentService {

    List<Payment> getPaymentsByUserId();
}
