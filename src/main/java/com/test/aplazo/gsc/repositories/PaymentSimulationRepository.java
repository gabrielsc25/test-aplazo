package com.test.aplazo.gsc.repositories;

import com.test.aplazo.gsc.entities.PaymentSimulationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentSimulationRepository extends JpaRepository<PaymentSimulationEntity, Long> {
}
