package org.example.airwaysticketbooking.DomainDriverDesign.order;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderHistoryController {

    private final OrderHistoryService orderHistoryService;

    @GetMapping
    public ResponseEntity<List<OrderHistoryDTO>> getOrderHistory(@RequestParam Long userId) {
        return ResponseEntity.ok(orderHistoryService.getOrderHistory(userId));
    }
}
