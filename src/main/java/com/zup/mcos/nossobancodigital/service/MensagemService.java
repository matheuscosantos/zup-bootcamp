package com.zup.mcos.nossobancodigital.service;

import com.zup.mcos.nossobancodigital.entity.LogDeAprovacao;
import com.zup.mcos.nossobancodigital.enumeration.Estado;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MensagemService {

    public Map<String, String> criaMensagemPorEstadoDeAceitacao(LogDeAprovacao logDeAprovacaoSalvo) {
        Map<String, String> mensagem = new HashMap<String, String>();
        if(logDeAprovacaoSalvo.getEstado() == Estado.ACEITE){
            mensagem.put("mensagem", "Olá, em breve iremos criar sua conta e enviaremos por email. Obrigado :)");
            return mensagem;
        }else{
            mensagem.put("mensagem", "");
        }
        return mensagem;
    }
}
