package com.zup.mcos.nossobancodigital.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class TransferenciaInterna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private ContaCorrente contaDeOrigem;

    @ManyToOne
    private ContaCorrente contaDeDestino;
    private BigDecimal valor;
//    private String codigoDoBancoDeDestino;
//    private String nomeDoBancoDeDestino;
//    private String agenciaDeDestino;
//    private String nomeDaPessoaFavorecida;
//    private String documentoDaPessoaFavorecida;
    private LocalDateTime dataEHoraDoPedido;
    private LocalDate diaDeEfetivacao;
}
