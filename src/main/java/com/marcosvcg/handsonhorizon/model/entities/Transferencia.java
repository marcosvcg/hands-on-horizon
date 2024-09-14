package com.marcosvcg.handsonhorizon.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transferencia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToOne
    private Conta contaOrigem;
    @OneToOne
    private Conta contaDestino;

    @Column(nullable = false)
    private BigDecimal valor;

    @Column(nullable = false)
    private Date data;

    public Transferencia(UUID id, BigDecimal valor, Date data) {
        this.id = id;
        this.valor = valor;
        this.data = data;
    }
}
