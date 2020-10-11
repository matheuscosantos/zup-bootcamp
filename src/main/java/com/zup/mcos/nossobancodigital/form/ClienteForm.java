package com.zup.mcos.nossobancodigital.form;

import com.zup.mcos.nossobancodigital.entity.Cliente;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ClienteForm {
    private String nome;
    private String sobrenome;
    private String email;
    private String cnh;
    private LocalDate dataDeNascimento;

    public Cliente toModel(ClienteForm clienteForm) {
        Cliente cliente = Cliente.builder()
                .cnh(clienteForm.getCnh())
                .dataDeNascimento(clienteForm.getDataDeNascimento())
                .email(clienteForm.getEmail())
                .nome(clienteForm.getNome())
                .sobrenome(clienteForm.getSobrenome())
                .build();
        return cliente;
    }
}