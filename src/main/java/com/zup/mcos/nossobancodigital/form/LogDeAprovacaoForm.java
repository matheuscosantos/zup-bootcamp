package com.zup.mcos.nossobancodigital.form;

import com.zup.mcos.nossobancodigital.entity.LogDeAprovacao;
import com.zup.mcos.nossobancodigital.enumeration.Estado;
import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Component
public class LogDeAprovacaoForm {
    private Estado estado;

    public LogDeAprovacao toModel(LogDeAprovacaoForm logDeAprovacaoForm){
        LogDeAprovacao log = LogDeAprovacao.builder()
                .estado(logDeAprovacaoForm.getEstado())
                .dataDeAlteracao(LocalDateTime.now())
                .build();
        return log;
    }
}
