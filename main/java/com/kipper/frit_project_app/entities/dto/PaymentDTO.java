package com.kipper.frit_project_app.entities.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kipper.frit_project_app.entities.Payment;

import java.time.Instant;

public record PaymentDTO(
        Long id,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
        Instant moment
) {
    public PaymentDTO(Payment payment) {
        this(
                payment.getId(),
                payment.getMoment()
        );
    }
}
