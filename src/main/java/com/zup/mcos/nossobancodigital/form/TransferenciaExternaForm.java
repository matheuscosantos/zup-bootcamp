package com.zup.mcos.nossobancodigital.form;

import com.zup.mcos.nossobancodigital.entity.ContaCorrente;
import com.zup.mcos.nossobancodigital.entity.TransferenciaExterna;
import com.zup.mcos.nossobancodigital.enumeration.TipoDeConta;
import com.zup.mcos.nossobancodigital.repository.ContaCorrenteRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class TransferenciaExternaForm {
    @NotEmpty(message = "A conta de origem precisa ser preenchida")
    @NotNull(message = "A conta de origem precisa ser preenchida")
    private String contaDeOrigem;
    @NotEmpty(message = "A agencia de origem precisa ser preenchida")
    @NotNull(message = "A agencia de origem precisa ser preenchida")
    private String agenciaDeOrigem;
    @NotEmpty(message = "A conta de destino precisa ser preenchida")
    @NotNull(message = "A conta de destino precisa ser preenchida")
    private String contaDeDestino;
    @NotEmpty(message = "A agencia de destino precisa ser preenchida")
    @NotNull(message = "A agencia de destino precisa ser preenchida")
    private String agenciaDeDestino;
    @NotEmpty(message = "O nome do banco precisa ser preenchido")
    @NotNull(message = "O nome do banco precisa ser preenchido")
    private String nomeDoBancoDeDestino;
    @NotEmpty(message = "O codigo do banco de destino precisa ser preenchido")
    @NotNull(message = "O codigo do banco de destino precisa ser preenchido")
    private String codigoDoBancoDeDestino;
    @NotEmpty(message = "O nome do favorecido precisa ser preenchido")
    @NotNull(message = "O nome do favorecido precisa ser preenchido")
    private String nomeDoFavorecido;
    @NotEmpty(message = "O documento precisa ser preenchido")
    @NotNull(message = "O documento precisa ser preenchido")
    private String documento;
    @NotEmpty(message = "O campo 'favorito' precisa ser preenchido")
    @NotNull(message = "O campo 'favorito' precisa ser preenchido")
    private Boolean favoritado;
    @NotEmpty(message = "A descrição precisa ser preenchida")
    @NotNull(message = "A descrição precisa ser preenchida")
    private String descricao;
    @FutureOrPresent(message = "A data da transferencia precisa ser no futuro ou no presente")
    private LocalDate dataDaSolicitacao;
    @Enumerated(EnumType.STRING)
    private TipoDeConta tipoDeConta;
    @NotNull
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
