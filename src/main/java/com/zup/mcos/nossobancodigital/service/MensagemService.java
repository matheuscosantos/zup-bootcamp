package com.zup.mcos.nossobancodigital.service;

import com.zup.mcos.nossobancodigital.entity.LogDeAprovacao;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface MensagemService {
    Map<String, String> criaMensagemPorEstadoDeAceitacao(LogDeAprovacao logDeAprovacaoSalvo);
}
