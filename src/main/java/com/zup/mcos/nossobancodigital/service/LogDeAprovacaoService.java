package com.zup.mcos.nossobancodigital.service;

import com.zup.mcos.nossobancodigital.entity.LogDeAprovacao;
import com.zup.mcos.nossobancodigital.form.LogDeAprovacaoForm;
import org.springframework.stereotype.Service;

@Service
public interface LogDeAprovacaoService {
    LogDeAprovacao alteraStatusDoClienteDeAcordoComAceitacao(Integer id, LogDeAprovacaoForm logDeAprovacaoForm);
}
