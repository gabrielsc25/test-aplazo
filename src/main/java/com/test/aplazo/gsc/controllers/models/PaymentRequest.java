package com.test.aplazo.gsc.controllers.models;

import com.test.aplazo.gsc.models.Payment;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.math.BigDecimal;

@Getter
@Setter
public class PaymentRequest {

    @NotNull
    @DecimalMin("1")
    @DecimalMax("999999")
    private BigDecimal amount;

    @NotNull
    @Min(4)
    @Max(52)
    private Integer terms;

    @NotNull
    @DecimalMin("1")
    @DecimalMax("100")
    private BigDecimal rate;

    public Payment toModel() {
        return Payment.builder()
            .amount(this.amount)
            .rate(this.rate)
            .terms(this.terms)
            .build();
    }
}
