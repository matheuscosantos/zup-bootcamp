package com.zup.mcos.nossobancodigital.form;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransferenciaInternaForm extends TransferenciaForm{
    @NotEmpty(message = "A agencia de destino precisa ser preenchida")
    @NotNull(message = "A agencia de destino precisa ser preenchida")
    private String agenciaDeDestino;
    @NotEmpty(message = "O numero da conta de destino precisa ser preenchida")
    @NotNull(message = "o numero da conta de destino precisa ser preenchida")
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

