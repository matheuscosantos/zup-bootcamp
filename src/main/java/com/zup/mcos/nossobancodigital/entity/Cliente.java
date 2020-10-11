package com.zup.mcos.nossobancodigital.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.zup.mcos.nossobancodigital.enumeration.Estado;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

import static javax.persistence.FetchType.LAZY;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Cliente{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String sobrenome;

    @Column(unique = true)
    private String email;
    private String cnh;
    private LocalDate dataDeNascimento;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    @ManyToOne
    private Endereco endereco;

//    public Cliente(String nome,
//                   String sobrenome,
//                   String email,
//                   String cnh,
//                   LocalDate dataDeNascimento,
//                   Endereco endereco) {
//        this.nome = nome;
//        this.sobrenome = sobrenome;
//        this.email = email;
//        this.cnh = cnh;
//        this.dataDeNascimento = dataDeNascimento;
//        this.endereco = endereco;
//    }

}
