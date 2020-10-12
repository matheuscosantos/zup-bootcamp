package com.zup.mcos.nossobancodigital.service.impl;

import com.zup.mcos.nossobancodigital.dto.ClienteEmailDTO;
import com.zup.mcos.nossobancodigital.dto.ContaEmailDTO;
import com.zup.mcos.nossobancodigital.entity.Cliente;
import com.zup.mcos.nossobancodigital.entity.ContaCorrente;
import com.zup.mcos.nossobancodigital.entity.LogDeAprovacao;
import com.zup.mcos.nossobancodigital.repository.ClienteRepository;
import com.zup.mcos.nossobancodigital.repository.ContaCorrenteRepository;
import com.zup.mcos.nossobancodigital.repository.LogDeAprovacaoRepository;
import com.zup.mcos.nossobancodigital.service.ContaCorrenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaCorrenteServiceImpl implements ContaCorrenteService {

    @Autowired
    ContaCorrenteRepository contaCorrenteRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    LogDeAprovacaoRepository logDeAprovacaoRepository;

    @Autowired
    EmailServiceImpl emailService;

    public ContaCorrente criaContaCorrenteParaCliente(Integer idCliente, Integer idLog) {
        Cliente cliente = clienteRepository.getOne(idCliente);
        LogDeAprovacao logDeAprovacao = logDeAprovacaoRepository.getOne(idLog);
        ContaCorrente contaCorrente = new ContaCorrente(cliente, logDeAprovacao);
        contaCorrenteRepository.save(contaCorrente);
        emailService.enviar(new ClienteEmailDTO(cliente), new ContaEmailDTO(contaCorrente));
        return contaCorrente;
    }
}
