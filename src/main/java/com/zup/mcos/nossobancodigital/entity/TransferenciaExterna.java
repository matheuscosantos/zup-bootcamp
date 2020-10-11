package com.zup.mcos.nossobancodigital.entity;

import com.zup.mcos.nossobancodigital.enumeration.TipoDeConta;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class TransferenciaExterna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private ContaCorrente contaDeOrigem;
    private String contaDeDestino;
    private String agenciaDeDestino;
    private String nomeDoBancoDeDestino;
    private String codigoDoBancoDeDestino;
    private String nomeDoFavorecido;
    private String documento;
    private Boolean favoritado;
    private String descricao;
    private LocalDate dataDaSolicitacao;
    private LocalDateTime dataEfetiva;
    @Enumerated(EnumType.STRING)
    private TipoDeConta tipoDeConta;
    private BigDecimal valor;

}
