package com.zup.mcos.nossobancodigital.dto;

import com.zup.mcos.nossobancodigital.entity.ContaCorrente;
import lombok.Getter;

@Getter
public class ContaEmailDTO {
    private String agencia;
    private String conta;
    private String codigoDoBanco;

    public ContaEmailDTO(ContaCorrente contaCorrente) {
        this.agencia = contaCorrente.getAgencia();
        this.conta = contaCorrente.getConta();
        this.codigoDoBanco = contaCorrente.getCodigoDoBanco();
    }
}
