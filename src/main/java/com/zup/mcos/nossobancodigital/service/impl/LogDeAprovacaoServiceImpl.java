package com.zup.mcos.nossobancodigital.service.impl;

import com.zup.mcos.nossobancodigital.entity.Cliente;
import com.zup.mcos.nossobancodigital.entity.LogDeAprovacao;
import com.zup.mcos.nossobancodigital.form.LogDeAprovacaoForm;
import com.zup.mcos.nossobancodigital.repository.ClienteRepository;
import com.zup.mcos.nossobancodigital.repository.LogDeAprovacaoRepository;
import com.zup.mcos.nossobancodigital.service.LogDeAprovacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogDeAprovacaoServiceImpl implements LogDeAprovacaoService {
    @Autowired
    LogDeAprovacaoRepository logDeAprovacaoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    public LogDeAprovacao alteraStatusDoClienteDeAcordoComAceitacao(Integer id, LogDeAprovacaoForm logDeAprovacaoForm) {
        Cliente cliente = clienteRepository.getOne(id);
        cliente.setEstado(logDeAprovacaoForm.getEstado());
        LogDeAprovacao logDeAprovacao = logDeAprovacaoForm.toModel(logDeAprovacaoForm);
        logDeAprovacao.setCliente(cliente);
        LogDeAprovacao novoLogDeAprovacao = logDeAprovacaoRepository.save(logDeAprovacao);
        return novoLogDeAprovacao;
    }
}
