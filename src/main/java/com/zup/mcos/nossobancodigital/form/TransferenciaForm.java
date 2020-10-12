package com.zup.mcos.nossobancodigital.form;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class TransferenciaForm {
    @NotEmpty(message = "A agencia da conta de origem precisa ser preenchida")
    @NotNull(message = "A agencia da conta de origem precisa ser preenchida")
    private String agenciaDaContaDeOrigem;
    @NotEmpty(message = "O numero da conta de origem precisa ser preenchida")
    @NotNull(message = "O numero da conta de origem precisa ser preenchida")
    private String numeroDaContaDeOrigem;
    @Positive(message = "O valor deve ser positivo")
    private BigDecimal valor;

    public TransferenciaForm(String agenciaDaContaDeOrigem,
                             String numeroDaContaDeOrigem,
                             BigDecimal valor) {
        this.agenciaDaContaDeOrigem = agenciaDaContaDeOrigem;
        this.numeroDaContaDeOrigem = numeroDaContaDeOrigem;
        this.valor = valor;
    }
}
