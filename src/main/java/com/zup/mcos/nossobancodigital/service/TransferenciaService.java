package com.zup.mcos.nossobancodigital.service;

import com.zup.mcos.nossobancodigital.entity.ContaCorrente;
import com.zup.mcos.nossobancodigital.entity.TransferenciaInterna;
import com.zup.mcos.nossobancodigital.form.TransferenciaInternaForm;
import com.zup.mcos.nossobancodigital.repository.ContaCorrenteRepository;
import com.zup.mcos.nossobancodigital.repository.TransferenciaInternaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class TransferenciaService {

    @Autowired
    ContaCorrenteRepository contaCorrenteRepository;

    @Autowired
    TransferenciaInternaRepository transferenciaRepository;

    public TransferenciaInterna solicitaTransferencia(TransferenciaInternaForm transferenciaForm) {

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

        this.salvaTransferencia(contaOrigem, contaDestino, transferenciaForm.getValor());

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

    public void salvaTransferencia(ContaCorrente contaOrigem,
                                   ContaCorrente contaDestino,
                                   BigDecimal valor){
        contaOrigem.setSaldo(contaOrigem.getSaldo().subtract(valor));
        contaDestino.setSaldo(contaDestino.getSaldo().add(valor));
        contaCorrenteRepository.save(contaOrigem);
        contaCorrenteRepository.save(contaDestino);
    }
}
