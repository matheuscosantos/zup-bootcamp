package com.zup.mcos.nossobancodigital.form;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransferenciaInternaForm extends TransferenciaForm{
    private String agenciaDeDestino;
    private String numeroDaContaDeDestino;

    public TransferenciaInternaForm(String agenciaDaContaDeOrigem,
                                    String numeroDaContaDeOrigem,
                                    BigDecimal valor,
                                    String agenciaDeDestino,
                                    String numeroDaContaDeDestino) {
        super(agenciaDaContaDeOrigem, numeroDaContaDeOrigem, valor);
        this.agenciaDeDestino = agenciaDeDestino;
        this.numeroDaContaDeDestino = numeroDaContaDeDestino;
    }
}

