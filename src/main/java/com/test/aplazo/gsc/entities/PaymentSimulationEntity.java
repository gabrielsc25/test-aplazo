package com.test.aplazo.gsc.entities;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name="payment_simulation")
public class PaymentSimulationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(columnDefinition = "json")
    private String request;

    @Column(columnDefinition = "json")
    private String response;

    @Column(updatable = false)
    private LocalDate created = LocalDate.now();

}
