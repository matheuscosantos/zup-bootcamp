package com.zup.mcos.nossobancodigital.service;

import com.zup.mcos.nossobancodigital.entity.Cliente;
import com.zup.mcos.nossobancodigital.entity.ContaCorrente;
import com.zup.mcos.nossobancodigital.entity.LogDeAprovacao;
import com.zup.mcos.nossobancodigital.repository.ClienteRepository;
import com.zup.mcos.nossobancodigital.repository.ContaCorrenteRepository;
import com.zup.mcos.nossobancodigital.repository.LogDeAprovacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaCorrenteService {

    @Autowired
    ContaCorrenteRepository contaCorrenteRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    LogDeAprovacaoRepository logDeAprovacaoRepository;

    public ContaCorrente criaContaCorrenteParaCliente(Integer idCliente, Integer idLog) {
        Cliente cliente = clienteRepository.getOne(idCliente);
        LogDeAprovacao logDeAprovacao = logDeAprovacaoRepository.getOne(idLog);
        ContaCorrente contaCorrente = new ContaCorrente(cliente, logDeAprovacao);
        contaCorrenteRepository.save(contaCorrente);
        return contaCorrente;
    }


}
