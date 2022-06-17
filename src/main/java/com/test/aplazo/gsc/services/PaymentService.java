package com.test.aplazo.gsc.services;

import com.test.aplazo.gsc.models.ParcelPayment;
import com.test.aplazo.gsc.models.Payment;

import java.util.List;

public interface PaymentService {
    List<ParcelPayment> calculate(final Payment payment) throws Throwable;
}
