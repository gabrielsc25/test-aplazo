package com.test.aplazo.gsc.services;

import com.test.aplazo.gsc.models.ParcelPayment;
import com.test.aplazo.gsc.models.Payment;

import java.util.List;

public interface SimulationService {
    void save(final Payment request, final List<ParcelPayment> response) throws Throwable;
}
