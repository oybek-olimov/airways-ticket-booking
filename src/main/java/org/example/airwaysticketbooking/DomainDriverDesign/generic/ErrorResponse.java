package org.example.airwaysticketbooking.DomainDriverDesign.generic;

import lombok.Getter;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Getter
public class ErrorResponse {

    private final String errorMessage;

    private final String errorPath;

    private final int errorCode;;

    private final LocalDateTime timestamp;

    public ErrorResponse(String errorMessage, String errorPath, int errorCode) {
        this.errorMessage = errorMessage;
        this.errorPath = errorPath;
        this.errorCode = errorCode;
        this.timestamp = LocalDateTime.now(Clock.system(ZoneId.of("Asia/Tashkent")));
    }
}
