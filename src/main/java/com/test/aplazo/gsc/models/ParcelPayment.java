package com.test.aplazo.gsc.models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.test.aplazo.gsc.controllers.models.ParcelPaymentResponse;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class ParcelPayment {
    private Integer paymentNumber;
    private BigDecimal amount;

    @JsonSerialize(using = LocalDateSerializer.class)
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate paymentDate;

    public ParcelPaymentResponse toResponse(){
        return new ParcelPaymentResponse(this.paymentNumber, this.amount, this.paymentDate);
    }
}
