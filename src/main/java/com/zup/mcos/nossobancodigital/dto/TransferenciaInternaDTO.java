package com.zup.mcos.nossobancodigital.dto;

import com.zup.mcos.nossobancodigital.entity.TransferenciaInterna;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransferenciaInternaDTO {
    private String contaDeOrigem;
    private String agenciaDeOrigem;
    private String contaDeDestino;
    private String agenciaDeDestino;
    private BigDecimal valor;
    private String dataEHoraDoPedido;

    public TransferenciaInternaDTO(TransferenciaInterna transferenciaInterna) {
        this.agenciaDeOrigem = transferenciaInterna.getContaDeDestino().getAgencia();
        this.contaDeOrigem = transferenciaInterna.getContaDeDestino().getConta();
        this.agenciaDeDestino = transferenciaInterna.getContaDeOrigem().getAgencia();
        this.contaDeDestino = transferenciaInterna.getContaDeOrigem().getConta();
        this.valor = transferenciaInterna.getValor();
        this.dataEHoraDoPedido = transferenciaInterna.getDataEHoraDoPedido().toString();
    }
}
