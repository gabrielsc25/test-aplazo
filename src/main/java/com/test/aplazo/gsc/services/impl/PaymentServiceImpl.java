package com.test.aplazo.gsc.services.impl;

import com.test.aplazo.gsc.models.ParcelPayment;
import com.test.aplazo.gsc.models.Payment;
import com.test.aplazo.gsc.services.PaymentService;
import com.test.aplazo.gsc.services.SimulationService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final SimulationService simulationService;

    public PaymentServiceImpl(SimulationService simulationService) {
        this.simulationService = simulationService;
    }

    @Override
    public List<ParcelPayment> calculate(final Payment payment) throws Throwable {
        var response = new ArrayList<ParcelPayment>(payment.getTerms());
        var terms = new BigDecimal(payment.getTerms());
        var tax = payment.getRate().divide(new BigDecimal(100));

        var monthTaxValue = payment.getAmount()
            .multiply(tax)
            .setScale(2, RoundingMode.HALF_UP);

        // generate parcels
        ParcelPayment parcelPayment = null;
        LocalDate start = LocalDate.now();
        var amountParcel = payment.getAmount().divide(terms);
        for (int i=1; i <= payment.getTerms();i++){
            parcelPayment = ParcelPayment.builder()
                .paymentDate(start)
                .amount(amountParcel.add(monthTaxValue))
                .paymentNumber(i)
                .build();

            response.add(parcelPayment);
            start = start.plusWeeks(1);
        }

        // store in DB
        this.simulationService.save(payment, response);

        return response;
    }
}
