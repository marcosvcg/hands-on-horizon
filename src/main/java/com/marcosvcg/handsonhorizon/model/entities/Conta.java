package com.marcosvcg.handsonhorizon.model.entities;

import com.marcosvcg.handsonhorizon.util.TipoContaEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String numero;

    @Column(nullable = false)
    private int digito;

    @Column(nullable = false)
    private BigDecimal saldo;

    @Column(nullable = false)
    private TipoContaEnum tipoConta;

    @OneToOne
    private Pessoa pessoa;
}
