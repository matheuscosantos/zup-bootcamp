package com.zup.mcos.nossobancodigital.service.impl;

import com.zup.mcos.nossobancodigital.entity.LogDeAprovacao;
import com.zup.mcos.nossobancodigital.enumeration.Estado;
import com.zup.mcos.nossobancodigital.service.MensagemService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MensagemServiceImpl implements MensagemService {

    public Map<String, String> criaMensagemPorEstadoDeAceitacao(LogDeAprovacao logDeAprovacaoSalvo) {
        Map<String, String> mensagem = new HashMap<String, String>();
        if(logDeAprovacaoSalvo.getEstado() == Estado.ACEITE){
            mensagem.put("mensagem", "Olá, em breve iremos criar sua conta e enviaremos por email. Obrigado :)");
            return mensagem;
        }else{
            mensagem.put("mensagem", "Olá, vamos verificar o motivo motivo pelos dados estarem incorretos e retornaremos o contato. Obrigado.");
            return mensagem;
        }
    }
}
