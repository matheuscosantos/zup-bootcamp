package com.zup.mcos.nossobancodigital.form;

import com.zup.mcos.nossobancodigital.entity.Cliente;
import com.zup.mcos.nossobancodigital.entity.LogDeAprovacao;
import com.zup.mcos.nossobancodigital.enumeration.Estado;
import com.zup.mcos.nossobancodigital.repository.ClienteRepository;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class LogDeAprovacaoForm {
    private Estado estado;

    @Autowired
    ClienteRepository clienteRepository;

    public LogDeAprovacao toModel(LogDeAprovacaoForm logDeAprovacaoForm){
        LogDeAprovacao log = LogDeAprovacao.builder()
                .estado(logDeAprovacaoForm.getEstado())
                .dataDeAlteracao(LocalDateTime.now())
                .build();
        return log;
    }
}
