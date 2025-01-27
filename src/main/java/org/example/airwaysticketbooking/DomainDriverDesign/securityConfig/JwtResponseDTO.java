package org.example.airwaysticketbooking.DomainDriverDesign.securityConfig;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class JwtResponseDTO {
    private String token;
    private String tokenType;

    public JwtResponseDTO(String token) {
        this.token = token;
        this.tokenType = "Bearer";
    }
}
