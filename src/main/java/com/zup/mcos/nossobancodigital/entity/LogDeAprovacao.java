package com.zup.mcos.nossobancodigital.entity;

import com.zup.mcos.nossobancodigital.enumeration.Estado;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class LogDeAprovacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Cliente cliente;

    @Enumerated(EnumType.STRING)
    private Estado estado;
    private LocalDateTime dataDeAlteracao;
}
