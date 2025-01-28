package org.example.airwaysticketbooking.DomainDriverDesign.payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment,Long> {

    @Query("SELECT p FROM Payment p JOIN p.ticket t WHERE t.passengerEmail = :userId")
    List<Payment> findByUserId(@Param("userId") Long userId);}
