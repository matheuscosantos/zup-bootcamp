package com.zup.mcos.nossobancodigital.form;

import com.zup.mcos.nossobancodigital.entity.ContaCorrente;
import com.zup.mcos.nossobancodigital.entity.TransferenciaExterna;
import com.zup.mcos.nossobancodigital.enumeration.TipoDeConta;
import com.zup.mcos.nossobancodigital.repository.ContaCorrenteRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransferenciaExternaForm {
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
    private LocalDate dataDaSolicitacao;
    @Enumerated(EnumType.STRING)
    private TipoDeConta tipoDeConta;
    private BigDecimal valor;


    @Autowired
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    ContaCorrenteRepository contaCorrenteRepository;

    public TransferenciaExterna toModel(TransferenciaExternaForm transferenciaExternaForm){

        ContaCorrente contaDeOrigem = contaCorrenteRepository.findByContaAndAgencia(
                transferenciaExternaForm.getContaDeOrigem(),
                transferenciaExternaForm.getAgenciaDeOrigem());

        TransferenciaExterna transferencia = TransferenciaExterna.builder()
                .contaDeOrigem(contaDeOrigem)
                .contaDeDestino(transferenciaExternaForm.getContaDeDestino())
                .agenciaDeDestino(transferenciaExternaForm.getAgenciaDeDestino())
                .nomeDoBancoDeDestino(transferenciaExternaForm.getNomeDoBancoDeDestino())
                .codigoDoBancoDeDestino(transferenciaExternaForm.getCodigoDoBancoDeDestino())
                .nomeDoFavorecido(transferenciaExternaForm.getNomeDoFavorecido())
                .documento(transferenciaExternaForm.getDocumento())
                .favoritado(transferenciaExternaForm.getFavoritado())
                .descricao(transferenciaExternaForm.getDescricao())
                .dataDaSolicitacao(transferenciaExternaForm.getDataDaSolicitacao())
                .tipoDeConta(transferenciaExternaForm.getTipoDeConta())
                .valor(transferenciaExternaForm.getValor())
                .build();

        return transferencia;
    }



}
