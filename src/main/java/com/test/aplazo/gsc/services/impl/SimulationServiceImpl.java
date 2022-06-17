package com.test.aplazo.gsc.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.aplazo.gsc.entities.PaymentSimulationEntity;
import com.test.aplazo.gsc.models.ParcelPayment;
import com.test.aplazo.gsc.models.Payment;
import com.test.aplazo.gsc.repositories.PaymentSimulationRepository;
import com.test.aplazo.gsc.services.SimulationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SimulationServiceImpl implements SimulationService {

    private final PaymentSimulationRepository repository;
    private final ObjectMapper mapper;

    public SimulationServiceImpl(PaymentSimulationRepository repository) {
        this.repository = repository;
        mapper = new ObjectMapper();
    }

    @Transactional
    @Override
    public void save(final Payment request, final List<ParcelPayment> response) throws Throwable {
        var entity = new PaymentSimulationEntity();
        entity.setRequest(mapper.writeValueAsString(request));
        entity.setResponse(mapper.writeValueAsString(response));

        this.repository.save(entity);
    }
}
