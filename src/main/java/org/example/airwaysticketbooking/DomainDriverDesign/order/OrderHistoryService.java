package org.example.airwaysticketbooking.DomainDriverDesign.order;

import java.util.List;

public interface OrderHistoryService {

    List<OrderHistoryDTO> getOrderHistory(Long userId);
}
