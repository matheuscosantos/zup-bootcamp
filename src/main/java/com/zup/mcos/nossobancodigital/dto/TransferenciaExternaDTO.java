package com.zup.mcos.nossobancodigital.dto;

import com.zup.mcos.nossobancodigital.enumeration.TipoDeConta;
import com.zup.mcos.nossobancodigital.form.TransferenciaExternaForm;
import lombok.Getter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@Getter
public class TransferenciaExternaDTO {
    private Integer id;
    private String contaDeOrigem;
    private String agenciaDeOrigem;
    private String contaDeDestino;
    private String agenciaDeDestino;
    private String nomeDoBancoDeDestino;
    private String codigoDoBancoDeDestino;
    private String nomeDoFavorecido;
    private String documento;
    private Boolean favoritado;
    private String descricao;
    private String dataDaSolicitacao;
    @Enumerated(EnumType.STRING)
    private TipoDeConta tipoDeConta;
    private BigDecimal valor;

    public TransferenciaExternaDTO(TransferenciaExternaForm transferenciaExterna) {
        this.contaDeOrigem = transferenciaExterna.getContaDeOrigem();
        this.agenciaDeOrigem = transferenciaExterna.getAgenciaDeOrigem();
        this.contaDeDestino = transferenciaExterna.getContaDeDestino();
        this.agenciaDeDestino = transferenciaExterna.getAgenciaDeDestino();
        this.nomeDoBancoDeDestino = transferenciaExterna.getNomeDoBancoDeDestino();
        this.codigoDoBancoDeDestino = transferenciaExterna.getCodigoDoBancoDeDestino();
        this.nomeDoFavorecido = transferenciaExterna.getNomeDoFavorecido();
        this.documento = transferenciaExterna.getDocumento();
        this.favoritado = transferenciaExterna.getFavoritado();
        this.descricao = transferenciaExterna.getDescricao();
        this.dataDaSolicitacao = transferenciaExterna.getDataDaSolicitacao().toString();
        this.tipoDeConta = transferenciaExterna.getTipoDeConta();
        this.valor = transferenciaExterna.getValor();
    }
}
