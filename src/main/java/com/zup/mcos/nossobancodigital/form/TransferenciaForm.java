package com.zup.mcos.nossobancodigital.form;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class TransferenciaForm {
    private String agenciaDaContaDeOrigem;
    private String numeroDaContaDeOrigem;
    private BigDecimal valor;

    public TransferenciaForm(String agenciaDaContaDeOrigem,
                             String numeroDaContaDeOrigem,
                             BigDecimal valor) {
        this.agenciaDaContaDeOrigem = agenciaDaContaDeOrigem;
        this.numeroDaContaDeOrigem = numeroDaContaDeOrigem;
        this.valor = valor;
    }
}
