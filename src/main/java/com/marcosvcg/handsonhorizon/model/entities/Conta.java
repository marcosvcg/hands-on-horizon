package com.marcosvcg.handsonhorizon.model.entities;

import com.marcosvcg.handsonhorizon.util.TipoContaEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Entity
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "pessoa_id")
    private Pessoa pessoa;

    @Column(nullable = false)
    private String numero;

    @Column(nullable = false)
    private int digito;

    @Column(nullable = false)
    private BigDecimal saldo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoContaEnum tipoConta;

    @OneToMany(mappedBy = "contaOrigem")
    private List<Transferencia> transferenciasOrigem;

    @OneToMany(mappedBy = "contaDestino")
    private List<Transferencia> transferenciasDestino;

    public Conta(UUID id, Pessoa pessoa, String numero, int digito, BigDecimal saldo, TipoContaEnum tipoContaEnum) {
        this.id = id;
        this.pessoa = pessoa;
        this.numero = numero;
        this.digito = digito;
        this.saldo = saldo;
        this.tipoConta = tipoContaEnum;
    }
}