package com.test.aplazo.gsc.controllers.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ParcelPaymentResponse {
    private Integer paymentNumber;
    private BigDecimal amount;
    private LocalDate paymentDate;
}
