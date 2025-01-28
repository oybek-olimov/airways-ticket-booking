package org.example.airwaysticketbooking.DomainDriverDesign.payment;

import lombok.RequiredArgsConstructor;
import org.example.airwaysticketbooking.DomainDriverDesign.securityConfig.SessionUser;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final SessionUser sessionUser;

    public List<Payment> getPaymentsByUserId() {
        Long userId = sessionUser.getCurrentUserId();
        return paymentRepository.findByUserId(userId);
    }
}
