package com.zup.mcos.nossobancodigital.service;

import com.zup.mcos.nossobancodigital.entity.ContaCorrente;
import com.zup.mcos.nossobancodigital.entity.TransferenciaInterna;
import com.zup.mcos.nossobancodigital.enumeration.TipoDeConta;
import com.zup.mcos.nossobancodigital.form.TransferenciaExternaForm;
import com.zup.mcos.nossobancodigital.form.TransferenciaInternaForm;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
public interface TransferenciaService {
    TransferenciaInterna solicitaTransferenciaInterna(TransferenciaInternaForm transferenciaForm);
    TransferenciaExternaForm solicitaTransferenciaExterna(TransferenciaExternaForm transferenciaForm);
    void salvaTransferenciaExterna(ContaCorrente contaOrigem,
                                   String agenciaDeDestino,
                                   String contaDeDestino,
                                   String codigoDoBancoDeDestino,
                                   LocalDate dataDaSolicitacao,
                                   String descricao,
                                   String documento,
                                   Boolean favoritado,
                                   String nomeDoBancoDeDestino,
                                   String nomeDoFavorecido,
                                   TipoDeConta tipoDeConta,
                                   BigDecimal valor);
    void salvaTransferenciaInterna(ContaCorrente contaOrigem,
                                   ContaCorrente contaDestino,
                                   BigDecimal valor);

}
