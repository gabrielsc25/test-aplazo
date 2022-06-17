package com.test.aplazo.gsc.models;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class Payment {
    private BigDecimal amount;
    private Integer terms;
    private BigDecimal rate;
}
