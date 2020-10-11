package com.zup.mcos.nossobancodigital.dto;

import com.zup.mcos.nossobancodigital.entity.Cliente;
import com.zup.mcos.nossobancodigital.entity.Endereco;
import com.zup.mcos.nossobancodigital.enumeration.Estado;
import lombok.*;

@Getter
public class ClienteDTO {
    private Integer id;
    private String nome;
    private String sobrenome;
    private String email;
    private String cnh;
    private String dataDeNascimento;
    private Endereco endereco;
    private Estado estado;

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.sobrenome = cliente.getSobrenome();
        this.email = cliente.getEmail();
        this.cnh = cliente.getCnh();
        this.dataDeNascimento = cliente.getDataDeNascimento().toString();
        this.endereco = cliente.getEndereco();
        this.estado = cliente.getEstado();
    }
}
