package com.zup.mcos.nossobancodigital.service.impl;

import com.zup.mcos.nossobancodigital.entity.ContaCorrente;
import com.zup.mcos.nossobancodigital.entity.TransferenciaExterna;
import com.zup.mcos.nossobancodigital.entity.TransferenciaInterna;
import com.zup.mcos.nossobancodigital.enumeration.TipoDeConta;
import com.zup.mcos.nossobancodigital.form.TransferenciaExternaForm;
import com.zup.mcos.nossobancodigital.form.TransferenciaInternaForm;
import com.zup.mcos.nossobancodigital.repository.ContaCorrenteRepository;
import com.zup.mcos.nossobancodigital.repository.TransferenciaExternaRepository;
import com.zup.mcos.nossobancodigital.repository.TransferenciaInternaRepository;
import com.zup.mcos.nossobancodigital.service.TransferenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class TransferenciaServiceImpl implements TransferenciaService {

    @Autowired
    ContaCorrenteRepository contaCorrenteRepository;

    @Autowired
    TransferenciaInternaRepository transferenciaRepository;

    @Autowired
    TransferenciaExternaRepository transferenciaExternaRepository;

    public TransferenciaInterna solicitaTransferenciaInterna(TransferenciaInternaForm transferenciaForm) {

        String numeroDaAgenciaDeOrigem = transferenciaForm.getAgenciaDaContaDeOrigem();
        String numeroDaContaDeOrigem = transferenciaForm.getNumeroDaContaDeOrigem();

        String numeroDaAgenciaDeDestino = transferenciaForm.getAgenciaDeDestino();
        String numeroDaContaDeDestino = transferenciaForm.getNumeroDaContaDeDestino();

        ContaCorrente contaOrigem = contaCorrenteRepository.findByContaAndAgencia(numeroDaContaDeOrigem,
                                                                                  numeroDaAgenciaDeOrigem
                                                                                 );
        ContaCorrente contaDestino = contaCorrenteRepository.findByContaAndAgencia(numeroDaContaDeDestino,
                                                                                   numeroDaAgenciaDeDestino
                                                                                  );

        this.salvaTransferenciaInterna(contaOrigem, contaDestino, transferenciaForm.getValor());

        TransferenciaInterna transferenciaInterna = TransferenciaInterna.builder()
                .contaDeOrigem(contaOrigem)
                .contaDeDestino(contaDestino)
                .valor(transferenciaForm.getValor())
                .dataEHoraDoPedido(LocalDateTime.now())
                .diaDeEfetivacao(LocalDate.now())
                .build();
        TransferenciaInterna transferenciaEfetuada = transferenciaRepository.save(transferenciaInterna);

        return transferenciaEfetuada;
    }

    public TransferenciaExternaForm solicitaTransferenciaExterna(TransferenciaExternaForm transferenciaForm) {

        String numeroDaAgenciaDeOrigem = transferenciaForm.getAgenciaDeOrigem();
        String numeroDaContaDeOrigem = transferenciaForm.getContaDeOrigem();

        ContaCorrente contaOrigem = contaCorrenteRepository.findByContaAndAgencia(
                numeroDaContaDeOrigem,
                numeroDaAgenciaDeOrigem
        );

       this.salvaTransferenciaExterna(contaOrigem,
            transferenciaForm.getAgenciaDeDestino(),
            transferenciaForm.getContaDeDestino(),
            transferenciaForm.getCodigoDoBancoDeDestino(),
            transferenciaForm.getDataDaSolicitacao(),
            transferenciaForm.getDescricao(),
            transferenciaForm.getDocumento(),
            transferenciaForm.getFavoritado(),
            transferenciaForm.getNomeDoBancoDeDestino(),
            transferenciaForm.getNomeDoFavorecido(),
            transferenciaForm.getTipoDeConta(),
            transferenciaForm.getValor()
            );

        contaOrigem.setSaldo(contaOrigem.getSaldo().subtract(transferenciaForm.getValor()));
        contaCorrenteRepository.save(contaOrigem);
        return transferenciaForm;
    }

    public void salvaTransferenciaExterna(ContaCorrente contaOrigem,
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
                                           BigDecimal valor) {

        TransferenciaExterna transferencia = TransferenciaExterna.builder()
                .contaDeOrigem(contaOrigem)
                .agenciaDeDestino(agenciaDeDestino)
                .contaDeDestino(contaDeDestino)
                .codigoDoBancoDeDestino(codigoDoBancoDeDestino)
                .dataDaSolicitacao(dataDaSolicitacao)
                .descricao(descricao)
                .documento(documento)
                .favoritado(favoritado)
                .nomeDoBancoDeDestino(nomeDoBancoDeDestino)
                .nomeDoFavorecido(nomeDoFavorecido)
                .tipoDeConta(tipoDeConta)
                .valor(valor)
                .build();

        transferenciaExternaRepository.save(transferencia);

    }

    public void salvaTransferenciaInterna(ContaCorrente contaOrigem,
                                          ContaCorrente contaDestino,
                                          BigDecimal valor){
        contaOrigem.setSaldo(contaOrigem.getSaldo().subtract(valor));
        contaDestino.setSaldo(contaDestino.getSaldo().add(valor));
        contaCorrenteRepository.save(contaOrigem);
        contaCorrenteRepository.save(contaDestino);
    }
}
