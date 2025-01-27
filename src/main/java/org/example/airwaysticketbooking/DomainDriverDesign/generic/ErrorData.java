package org.example.airwaysticketbooking.DomainDriverDesign.generic;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ErrorData(String message,Object... params) {
}
