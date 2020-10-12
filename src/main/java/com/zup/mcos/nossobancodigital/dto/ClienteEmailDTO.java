package com.zup.mcos.nossobancodigital.dto;

import com.zup.mcos.nossobancodigital.entity.Cliente;
import lombok.Getter;

@Getter
public class ClienteEmailDTO {
    private String nome;
    private String email;

    public ClienteEmailDTO(Cliente cliente) {
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
    }
}
