package com.zup.mcos.nossobancodigital.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Random;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ContaCorrente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private LogDeAprovacao logDeAprovacao;

    private String agencia;
    private String conta;
    private String codigoDoBanco;
    private BigDecimal saldo;

    public ContaCorrente(Cliente cliente, LogDeAprovacao logDeAprovacao) {
        Random random = new Random();
        this.cliente = cliente;
        this.agencia = String.valueOf(random.nextInt(9999));
        this.conta = String.valueOf(random.nextInt(99999999));;
        this.codigoDoBanco = "777";
        this.saldo = BigDecimal.ZERO;
        this.logDeAprovacao = logDeAprovacao;
    }





}
